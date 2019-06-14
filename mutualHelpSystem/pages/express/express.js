var utils = require('../../utils/util.js');

var app = getApp();

Page({

  /**
   * 页面的初始数据
   */
  data: {
    expresses: [],
    windowHeight: "",
    windowWidth: "",
    currPage: 1,

    no_more: false, //没有更多了
    hidden: false,

    indicatorDots: true,
    autoplay: false,
    interval: 5000,
    duration: 1000
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    wx.getSystemInfo({
      success: (res) => {
        this.setData({
          windowHeight: res.windowHeight,
          windowWidth: res.windowWidth
        })
      }
    })
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
    this.setData({
      expresses: [],
      currPage: 1,
    })
    this.getOrderByPage();
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

  pullDownRefresh: function (e) {

  },

  pullUpLoad: function (e) {


  },
  detail: function (e) {
    var phone = wx.getStorageSync('phone');
    if (phone) {
      wx.navigateTo({
        url: "/pages/express/express_detail/express_detail?express_detail_id=" + e.currentTarget.id
      })
    } else {
      wx.showModal({
        content: '请先登录,再查看详情',
        showCancel: false,
        confirmText: "确定",
        success(res) {
          if (res.confirm) {
            wx.switchTab({
              url: '/pages/user/user',
            })
          }
        }
      })
    }
  },

  search: function () {
    wx.navigateTo({
      url: '/pages/express/express_search/express_search',
    })

  },

  onloadmore: function () {
    var that = this;
    var currPage = that.data.currPage;
    this.setData({
      hidden: false
    }); 
    wx.request({
      url: app.globalData.url + '/express/getByPage',
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      data: {
        currPage: currPage + 1
      },
      method: 'GET',
      success: function (res) {

        if (res.data.data == null) { //没有更多的时候
          that.setData({
            no_more: true,
            hidden: true
          });
        } else {
          that.parseOrderData(res);
          that.setData({
            hidden: true,
            currPage: currPage + 1
          });
        }
      }
    })
  },

  parseOrderData: function (res) {
    var that = this;
    let es = that.data.expresses;
    for (var i = 0; i < res.data.data.length; i++) {
      var date = res.data.data[i].expressDetail.express_publishtime;
      if (date != null) {
        date = utils.formatTime(new Date(date))
        res.data.data[i].expressDetail.express_publishtime = date;
      }
      es.push(res.data.data[i])
    }
    that.setData({
      expresses: es
    })
  },


  getOrderByPage: function () {
    var that = this;
    wx.request({
      url: app.globalData.url + '/express/getByPage',
      data: {
        currPage: this.data.currPage
      },
      method: 'GET',
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      success: function (res) {
        if (res.data.code == "200") {
          that.parseOrderData(res);
        }
        if (res.data.code == "201") {
          wx.showModal({
            content: res.data.message,
            showCancel: false,
            confirmText: "确定"
          })
        }
      },
      fail: function () {
        console.log("请求出错");
      }
    })
  }
})