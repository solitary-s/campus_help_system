// pages/order/order_express_detail/order_express_detail.js
var utils = require('../../../utils/util.js');
var app = getApp();

Page({

  /**
   * 页面的初始数据
   */
  data: {
    express_detail_id: "",
    currentTab_one: 0,
    express: {},
    hiddenFlag0: false,
    hiddenFlag1: false,
    hiddenFlag2: false,
    hiddenFlag3: false,
    accept_id: "",
    username: "",
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.data.express_detail_id = options.express_detail_id;
    this.data.currentTab_one = options.currentTab_one;
    this.getExpressByDetailId();
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    if (this.data.currentTab_one == 0) {
      this.setData({
        hiddenFlag0: true
      })
    } else if (this.data.currentTab_one == 1) {
      this.setData({
        hiddenFlag1: true
      })
    } else if (this.data.currentTab_one == 2) {
      this.setData({
        hiddenFlag2: true
      })
    } else if (this.data.currentTab_one == 3) {
      this.setData({
        hiddenFlag3: true
      })
    }
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },
  finish_order: function () {
    var that = this
    wx.request({
      url: app.globalData.url + '/express/finish',
      data: {
        express_detail_id: this.data.express_detail_id
      },
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      method: 'GET',
      success: function (res) {
        if (res.data.code == 200) {
          wx.showModal({
            content: res.data.message,
            showCancel: false,
            confirmText: "确定",
            success(res) {
              wx.switchTab({
                url: '/pages/order/order',
              })
            }
          })
        } else {
          console.log("获取失败")
        }
      }
    })
  },
  cancel_order: function () {
    var that = this
    wx.request({
      url: app.globalData.url + '/express/cancel',
      data: {
        express_detail_id: this.data.express_detail_id
      },
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      method: 'GET',
      success: function (res) {
        if (res.data.code == 200) {
          wx.showModal({
            content: res.data.message,
            showCancel: false,
            confirmText: "确定",
            success(res) {
              wx.switchTab({
                url: '/pages/order/order',
              })
            }
          })
        } else {
          console.log("获取失败")
        }
      }
    })
  },

  getUser: function (accept_id) {
    var that = this
    wx.request({
      url: app.globalData.url + '/user/get',
      data: {
        acceptId: accept_id
      },
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      method: 'GET',
      success: function (res) {
        if (res.data.code == 200) {
          that.setData({
            accept_id: res.data.data.account,
            username: res.data.data.username
          })
        } else {
          console.log("获取失败")
        }
      }
    })
  },

  getExpressByDetailId: function () {
    var that = this
    wx.request({
      url: app.globalData.url + '/express/detail',
      data: {
        express_detail_id: this.data.express_detail_id
      },
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      method: 'GET',
      success: function (res) {
        if (res.data.code == 200) {
          var date = res.data.data.expressDetail.express_publishtime;
          if (date != null) {
            date = utils.formatTime(new Date(date))
            res.data.data.expressDetail.express_publishtime = date;
          }
          
          if(res.data.data.accept_id != null){
            that.getUser(res.data.data.accept_id);
          }

          that.setData({
            accept_id: res.data.data.accept_id,
            express: res.data.data
          });

        } else {
          console.log("获取失败")
        }
      }
    })
  }
})