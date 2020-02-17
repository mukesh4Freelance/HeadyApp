package com.jinxtris.ram.headapp.viewModel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import com.jinxtris.ram.headapp.extension.toast
import com.jinxtris.ram.headapp.model.Root
import com.jinxtris.ram.headapp.repository.MainRepository
import com.jinxtris.ram.headapp.retrofit.APIService
import com.jinxtris.ram.headapp.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : BaseViewModel(), LifecycleObserver {
    var rootLiveData = MutableLiveData<Root>()
    private val mainRepository = MainRepository


    fun callService() {
        val service = RetrofitClient.retroInstance?.create(APIService::class.java)
        val call = service?.categoryData()

        call?.enqueue(object : Callback<Root> {
            override fun onFailure(call: Call<Root>, t: Throwable) {
                toast("Failure")
            }

            override fun onResponse(call: Call<Root>, response: Response<Root>) {
                val body = response?.body()
                val information = body?.categories
                val ranking = body?.rankings
                toast(
                    "Category Size: ${information?.size} \n Ranking Size : ${ranking?.size}")
                            val categoryData = information
                            val rankings = ranking
                            val rootData = Root()
                rootData.categories = categoryData
                rootData.rankings = rankings
                rootLiveData.postValue(rootData)
            }

        })
    }


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