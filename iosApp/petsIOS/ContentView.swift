//
//  ContentView.swift
//  petsIOS
//
//  Created by Aleksei Anisimov on 31.01.2022.
//

import Combine
import SwiftUI
import shared

struct ContentView: View {
    var body: some View {
        var uc = GetLoginHistoryUseCaseImpl()
        var vm = LoginViewModelImpl(getLoginHistoryUseCase: uc, loginDataSource: LoginDataSourceImpl())
        
        ObservingView(publisher: asPublisher(vm.items)) { messages in
            
//            var objCArray = NSMutableArray(array: messages)
//            let swiftArray: [LoginMessageVO] = objCArray.compactMap({ $0 as? LoginMessageVO })
            let swiftArray:[LoginMessageVO] = messages.toArray()
            ZStack {
                List(swiftArray, id: \.self) { message in
                    let isSystem = message.source == LoginMessageSource.system
                        Text(String(message.text))
                           .frame(maxWidth: .infinity, alignment: isSystem ? .leading : .trailing)
                           .scaleEffect(x: 1, y: -1, anchor: .center)
                }.scaleEffect(x: 1, y: -1, anchor: .center)
            }
            
        }
    }
}

extension NSArray {
    
    func toArray<T>() -> Array<T> {
        var result = [T]()
          self.forEach {
              result.append($0 as! T)
          }
          return result

    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}


func asPublisher<T>(_ flow: CFlow<T>) -> AnyPublisher<T, Never> {
    return Deferred<Publishers.HandleEvents<PassthroughSubject<T, Never>>> {
        let subject = PassthroughSubject<T, Never>()
        let closable = flow.watch { next in
//            if let next = next {
                subject.send(next)
//            }
        }
        return subject.handleEvents(receiveCancel: {
            closable.close()
        })
    }.eraseToAnyPublisher()
}

private class ObservableModel<Observed>: ObservableObject {
    @Published var observed: Observed?

    init(publisher: AnyPublisher<Observed, Never>) {
        publisher
            .compactMap { $0 }
            .receive(on: DispatchQueue.main)
            .assign(to: &$observed)
    }
}

public struct ObservingView<Observed, Content>: View where Content: View {

    @ObservedObject private var model: ObservableModel<Observed>

    private let content: (Observed) -> Content

    public init(publisher: AnyPublisher<Observed, Never>, @ViewBuilder content: @escaping (Observed) -> Content) {
        self.model = ObservableModel(publisher: publisher)
        self.content = content
    }

    public var body: some View {
        let view: AnyView
        if let observed = self.model.observed {
            view = AnyView(content(observed))
        } else {
            view = AnyView(EmptyView())
        }
        return view
    }
}
