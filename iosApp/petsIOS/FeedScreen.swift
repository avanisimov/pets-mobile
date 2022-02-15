//
//  FeedScreen.swift
//  petsIOS
//
//  Created by Aleksei Anisimov on 15.02.2022.
//

import SwiftUI
import Foundation
import shared

struct FeedScreen: View {
    var body: some View {
        
        let vm: FeedViewModel = FeedViewModelImpl()
        
        ZStack {
            ObservingView(publisher: asPublisher(vm.items)) { itemsArray in
                let items:[ViewObject] = itemsArray.toArray()
                List(items, id: \.id) { item in
                    if let feedItem = item as? FeedItemVO {
                        FeedItemWidget(feedItem: feedItem)
                            .listRowSeparator(.hidden)
                    }
                }
                .listStyle(.plain)
            }
        }
    }
}

struct FeedItemWidget:View {
    var feedItem: FeedItemVO
    var body: some View {
        VStack {
            HStack {
                if let imageUrl = feedItem.author.image as? ImageVO.Url {
                    AsyncImage(url: URL(string: imageUrl.url)) { image in
                        image
                                 .resizable()
                                 .scaledToFill()
                    } placeholder: {
                        ProgressView()
                    }
                        .frame(width: 48, height: 48)
                        .background(Color.gray)
                        .clipShape(Circle())
                }
                VStack {
                    Text(String(feedItem.author.name.localized()))
                    Text(String(feedItem.date.localized()))
                        
                }
            }
            .frame(
                minWidth: 0,
                maxWidth: .infinity,
                minHeight: 0,
                maxHeight: .infinity,
                alignment: .topLeading
            )
            Text(String(feedItem.text.localized()))
                .lineLimit(4)
                .frame(
                    minWidth: 0,
                    maxWidth: .infinity,
                    minHeight: 0,
                    maxHeight: .infinity,
                    alignment: .topLeading
                )
        }
    }
}
