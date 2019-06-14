// pages/usedMarket/usedMarket_detail/usedMarket_detail.js
var utils = require('../../../utils/util.js');
var app = getApp();

Page({

  /**
   * 页面的初始数据
   */
  data: {
    used_detail_id: "",
    used_img:"",
    used: {},
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.data.used_detail_id = options.used_detail_id;
    this.getUsedByDetailId();
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

  used_accept: function () {
    var that = this;
    var phone = wx.getStorageSync('phone');

    if (phone === that.data.used.publish_id) {
      wx.showModal({
        content: "自己不能接自己发布订单",
        showCancel: false,
        confirmText: "确定",
      })
    } else {
      wx.request({
        url: app.globalData.url + '/used/accept',
        data: {
          used_detail_id: this.data.used_detail_id,
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

  getUsedByDetailId: function () {
    var that = this
    wx.request({
      url: app.globalData.url + '/used/detail',
      data: {
        used_detail_id: this.data.used_detail_id
      },
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      method: 'GET',
      success: function (res) {
        if (res.data.code == 200) {
          var date = res.data.data.usedDetail.used_publishtime;
          var used_img = res.data.data.usedDetail.used_img;
          if (date != null) {
            date = utils.formatTime(new Date(date))
            res.data.data.usedDetail.used_publishtime = date;
          }
          that.setData({
            used: res.data.data,
            used_img: app.globalData.url + '/uploads/' +used_img
          });
        } else {
          console.log("获取失败")
        }
      }
    })
  }

})