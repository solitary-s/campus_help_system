// pages/order/order_used_detail/order_used_detail.js
var utils = require('../../../utils/util.js');
var app = getApp();

Page({

  /**
   * 页面的初始数据
   */
  data: {
    used_detail_id: "",
    currentTab_two: 0,
    used: {},
    hiddenFlag0: false,
    hiddenFlag1: false,
    hiddenFlag2: false,
    hiddenFlag3: false,
    accept_id: "",
    username: "",
    used_img:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.data.used_detail_id = options.used_detail_id;
    this.data.currentTab_two = options.currentTab_two;
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
    if (this.data.currentTab_two == 0) {
      this.setData({
        hiddenFlag0: true
      })
    } else if (this.data.currentTab_two == 1) {
      this.setData({
        hiddenFlag1: true
      })
    } else if (this.data.currentTab_two == 2) {
      this.setData({
        hiddenFlag2: true
      })
    } else if (this.data.currentTab_two == 3) {
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
      url: app.globalData.url + '/used/finish',
      data: {
        used_detail_id: this.data.used_detail_id
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
      url: app.globalData.url + '/used/cancel',
      data: {
        used_detail_id: this.data.used_detail_id
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
          if (date != null) {
            date = utils.formatTime(new Date(date))
            res.data.data.usedDetail.used_publishtime = date;
          }

          if (res.data.data.accept_id != null) {
            that.getUser(res.data.data.accept_id);
          }

          that.setData({
            used_img: app.globalData.url + '/uploads/' + res.data.data.usedDetail.used_img,
            accept_id: res.data.data.accept_id,
            used: res.data.data,
            
          });

        } else {
          console.log("获取失败")
        }
      }
    })
  }
})