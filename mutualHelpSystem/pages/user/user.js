// pages/user/user.js

var app = getApp();
Page({
  data: {
    display_login: "",//是否显示登录的按钮
    display_user: "",//是否显示个人信息
    phone: "",
    username: "",
    user:"",
  },
  onLoad: function (options) {
    // 页面初始化 options为页面跳转所带来的参数
    this.Login_or();
  },
  onReady: function () {
    // 页面渲染完成
  },
  onShow: function () {
    // 页面显示
    this.Login_or();
  },
  onHide: function () {
    // 页面隐藏
  },
  onUnload: function () {
    // 页面关闭
  },
  //跳转到用户登录页面
  to_login: function () {
    //登录界面
    wx.navigateTo({
      url: '/pages/login/login'
    })
  },

  //判断是否已经登录
  Login_or: function () {
    var phone = wx.getStorageSync('phone');
    var username = wx.getStorageSync('username');
    var user = wx.getStorageSync('user');
    if (phone) {
      this.setData({
        display_login: "none",
        display_user: "block",
        user:user,
        phone: phone,
        username: username
      })

    } else {
      this.setData({ display_login: "block", display_user: "none" })
    }
  },

  downLogin: function () {
    wx.removeStorageSync('phone');
    this.Login_or();
  },

  publishExpress: function(){
    wx.navigateTo({
      url: '/pages/user/publishExpress/publishExpress',
    })
  },
  publishUsed: function () {
    wx.navigateTo({
      url: '/pages/user/publishUsed/publishUsed',
    })
  }

})