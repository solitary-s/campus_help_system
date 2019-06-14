// pages/express/express_detail/express_detail.js
var utils = require('../../../utils/util.js');
var app = getApp();

Page({

  /**
   * 页面的初始数据
   */
  data: {
    express_detail_id: "",
    express: {},
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.data.express_detail_id = options.express_detail_id;
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

  express_accept: function () {
    var that = this;
    var phone = wx.getStorageSync('phone');

    if (phone === that.data.express.publish_id) {
      wx.showModal({
        content: "自己不能接自己发布订单",
        showCancel: false,
        confirmText: "确定",
      })
    } else {
      wx.request({
        url: app.globalData.url + '/express/accept',
        data: {
          express_detail_id: that.data.express_detail_id,
          accept_id: phone
        },
        header: {
          "Content-Type": "application/x-www-form-urlencoded"
        },
        method: 'POST',
        success: function (res) {
          if (res.data.code == 200) {
            wx.showModal({
              content: res.data.message,
              showCancel: false,
              confirmText: "确定",
              success(res) {
                if (res.confirm) {
                  wx.switchTab({
                    url: '/pages/order/order',
                  })
                }
              }
            })
          } else {
            console.log("获取失败")
          }
        }
      })
    }
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
          that.setData({
            express: res.data.data
          });
        } else {
          console.log("获取失败")
        }
      }
    })
  }

})