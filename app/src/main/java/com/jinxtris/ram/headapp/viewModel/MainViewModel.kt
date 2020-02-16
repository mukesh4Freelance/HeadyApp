package com.jinxtris.ram.headapp.viewModel

import androidx.lifecycle.LifecycleObserver

class MainViewModel : BaseViewModel(), LifecycleObserver {
    //var openOrderListLiveData = MutableLiveData<MutableList<OpenOrderList>>()
    //private val portfolioRepository = PortfolioRepository


    /*fun callOrderBookAPIRequest() {
        isConnectedToInternet {
            networkThread {
                setIsLoading(true)
                val channel = ApplicationHelper.channel
                val orderRequest = TradeOuterClass.GetOrderBookRequest.newBuilder()
                    *//*.setClientId(clientId)
                    .setSessionId(sessionId)*//*
                    .build()

                portfolioRepository.callOrderBookApi(
                    orderRequest = orderRequest,
                    channel = channel
                )
                    ?.subscribe(object :
                        SingleObserver<TradeOuterClass.GetOrderBookResponse> {
                        override fun onSuccess(response: TradeOuterClass.GetOrderBookResponse) {
                            setIsLoading(false)

                            when {
                                response.statusCode == 200L -> {
                                    ioThread {
                                        portfolioRepository.deleteOrderList()

                                        val openOrderObject = OpenOrderList()

                                        response.dataList.forEach {
                                            ioThread {
                                                val data = it

                                                data.apply {
                                                    openOrderObject.clientId = clientId
                                                    openOrderObject.segment = segment
                                                    openOrderObject.orderDuration = ordDuration
                                                    openOrderObject.product = product
                                                    openOrderObject.ordertype = orderType
                                                    openOrderObject.tradeSymbol = trdSymbol
                                                    openOrderObject.instrumentType = instrumentType
                                                    openOrderObject.symbolGroup = symbolGroup
                                                    openOrderObject.expiryDate = expiryDate
                                                    openOrderObject.strikePrice = strikePrice
                                                    openOrderObject.optionType = optionType
                                                    openOrderObject.symbolName = symbolName
                                                    openOrderObject.lotSize = lotsize
                                                    openOrderObject.decimalLocator = decimalLocator
                                                    openOrderObject.multiplier = multiplier
                                                    openOrderObject.transType = transType
                                                    openOrderObject.guiOrdId = guiOrdId
                                                    openOrderObject.executiveBroker = execBroker
                                                    openOrderObject.guiOrgOrdId = guiOrgOrdId
                                                    openOrderObject.token = token
                                                    openOrderObject.price = price
                                                    openOrderObject.triggerPrice = triggerPrice
                                                    openOrderObject.quantity = quantity
                                                    openOrderObject.discQuantity = discQuantity
                                                    openOrderObject.cancelledSize = cancelledSize
                                                    openOrderObject.classification = classification
                                                    openOrderObject.user = user
                                                    openOrderObject.tickSize = tickSize
                                                    openOrderObject.averagePrice = avgPrice
                                                    openOrderObject.filledShares = filledShares
                                                    openOrderObject.unfilledSize = unfilledSize
                                                    openOrderObject.nestOrderNum = nestOrdNum
                                                    openOrderObject.requestId = reqId
                                                    openOrderObject.exchangeOrderId = exchOrdId
                                                    openOrderObject.status = status
                                                    openOrderObject.orderStatus = ordStatus
                                                    openOrderObject.nestUpdateTime = nestUpdateTime
                                                    openOrderObject.exchangeTime = exchTime
                                                    openOrderObject.exchangeOrderUpdateTime =
                                                        exchOrdUpdateTime
                                                    openOrderObject.rejectionBy = rejectionBy
                                                    openOrderObject.orderValidityDate =
                                                        orderValidityDate
                                                    openOrderObject.symbolDescription =
                                                        symbolDescription
                                                    openOrderObject.statusMessage = statusMessage
                                                }

                                                portfolioRepository.saveOrderData(openOrderObject)
                                            }

                                        }
                                        subscribeOpenOrderList()
                                    }
                                }
                                response.statusCode == 500L -> {
                                    toast(response.message)
                                    invalidSessionLiveData.postValue(response)
                                }
                                else -> toast(response.message)
                            }
                        }

                        override fun onSubscribe(d: Disposable) {
                            getCompositeDisposable().add(d)
                        }

                        override fun onError(e: Throwable) {
                            e.printStackTrace()
                            setIsLoading(false)

                            subscribeOpenOrderList()
                        }
                    })
            }
        }
    }*/
}