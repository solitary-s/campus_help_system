// pages/login/login.js

var app = getApp();
Page({
  data: {
    // tab切换 
    currentTab: 0,
    winWidth: 0,
    winHeight: 0,


  },
  onLoad: function (options) {
    // 页面初始化 options为页面跳转所带来的参数
    // 获取系统信息 
    var that = this;
    wx.getSystemInfo({
      success: function (res) {
        that.setData({
          winWidth: res.windowWidth,
          winHeight: res.windowHeight
        });
      }
    });
  },
  onReady: function () {
    // 页面渲染完成
  },
  onShow: function () {
    // 页面显示
  },
  onHide: function () {
    // 页面隐藏
  },
  onUnload: function () {
    // 页面关闭
  },
  // 滑动切换tab 
  bindChange: function (e) {
    var that = this;
    // console.log(e);
    that.setData({
      currentTab: e.detail.current
    });
  },
  // 点击tab切换 
  swichNav: function (e) {
    var that = this;
    if (this.data.currentTab === e.target.dataset.current) {
      return false;
    } else {
      that.setData({
        currentTab: e.target.dataset.current
      })
    }
  },
  //用户登陆
  userLogin: function (e) {
    var that = this;
    var account = e.detail.value.account;
    var password = e.detail.value.password;
    if (account == "" || password == "") {
      wx.showModal({
        content: '请输入完整信息！',
        success: function (res) {
          if (res.confirm) {
            console.log('用户点击确定')
          }
        }
      })
    } else {
      wx.request({
        url: app.globalData.url + '/user/login',
        data: {
          account: account,
          password: password,
        },
        method: 'POST',
        header: {
          "Content-Type": "application/x-www-form-urlencoded"
        },
        success: function (res) {
          
          if (res.data.code == "200") {
            wx.setStorageSync('phone', res.data.data.account);
            wx.setStorageSync('username', res.data.data.username);
            wx.setStorageSync('user', res.data.data);

            wx.showModal({
              content: res.data.message,
              showCancel: false,
              confirmText: "确定"
            })

            wx.switchTab({
              url: '/pages/user/user',
            })
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
  },

  //用户注册
  userRegister: function (e) {
    var that = this;
    var account = e.detail.value.account;
    var password = e.detail.value.password;
    var password_again = e.detail.value.password_again;
    var nickname = e.detail.value.nickname;
    var email = e.detail.value.email;

    if (account == "" || password == "" || password_again == "" || password == "" || nickname == "" || email == "") {
      wx.showModal({
        content: '请输入完整信息！',
        success: function (res) {
          if (res.confirm) {
            console.log('用户点击确定')
          }
        }
      })
    } else {
      if (account.length === 11) {
        if (password == password_again) {
          if (that.checkEmail(email)) {
            wx.request({
              url: app.globalData.url + '/user/register',
              data: {
                account: account,
                password: password,
                email: email,
                username: nickname,
              },
              method: "POST",
              header: {
                "Content-Type": "application/x-www-form-urlencoded"
              },
              success: function (res) {
                if (res.data.code == "200") {
                  wx.showModal({
                    content: res.data.message,
                    showCancel: false,
                    confirmText: "确定"
                  })
                  wx.navigateTo({
                    url: '/pages/login/login',
                  })
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
        } else {
          wx.showModal({ //失败弹窗
            content: "密码两次输入不匹配",
            showCancel: false,
            confirmText: "确定"
          })
        }
      } else {
        wx.showModal({ //失败弹窗
          content: "手机账号输入错误",
          showCancel: false,
          confirmText: "确定"
        })
      }
    }
  },

  // 获取输入框内容
  bindKeyInput_phone: function (e) {
    let phoneNumber = e.detail.value
    if (phoneNumber.length === 11) {
      let checkedNum = this.checkPhoneNum(phoneNumber)
    }
  },
  checkPhoneNum: function (phoneNumber) {
    let str = /^1\d{10}$/
    if (str.test(phoneNumber)) {
      return true
    } else {
      wx.showModal({
        content: "手机账号输入错误",
        showCancel: false,
        confirmText: "确定"
      })
      return false
    }
  },

  // 邮箱验证部分
  bindKeyInput_email: function (e) {
    let email = e.detail.value
    let checkedEmail = this.checkEmail(email)
  },
  checkEmail: function (email) {
    let str = /^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/
    if (str.test(email)) {
      return true
    } else {
      wx.showModal({
        content: "email输入错误",
        showCancel: false,
        confirmText: "确定"
      })
      return false
    }
  }

})