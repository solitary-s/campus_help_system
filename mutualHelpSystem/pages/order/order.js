var utils = require('../../utils/util.js');

var app = getApp();

Page({

  /**
   * 页面的初始数据
   */
  data: {
    display: "",
    display_order: "",

    currentTab: 0,
    currentTab_one:0,
    currentTab_two:0,
    winWidth: 0,
    winHeight: 0,
    express_publish: [],
    express_accept: [],
    express_process: [],
    express_finish: [],
    used_publish: [],
    used_accept: [],
    used_process: [],
    used_finish: [],
    express_size: 4,
    used_size:4,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    wx.getSystemInfo({
      success: function (res) {
        that.setData({
          winWidth: res.windowWidth,
          winHeight: res.windowHeight
        });
      }
    });
    that.is_login();
    that.getExpressByPublish();
    that.getUsedByPublish();
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
    this.is_login();
    this.getExpressByPublish();
    this.getUsedByPublish();
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

  express_detail: function (e) {
    wx.navigateTo({
      url: "/pages/order/order_express_detail/order_express_detail?express_detail_id=" + e.currentTarget.id + "&currentTab_one=" + this.data.currentTab_one
    })

  },

  used_detail: function (e) {
    wx.navigateTo({
      url: "/pages/order/order_used_detail/order_used_detail?used_detail_id=" + e.currentTarget.id + "&currentTab_two=" + this.data.currentTab_two
    })

  },

  is_login: function () {
    var that = this;
    var phone = wx.getStorageSync('phone');
    if (phone) {
      that.setData({
        display: "none",
        display_order: "block",
        currentTab: 0,
        currentTab_one: 0,
        currentTab_two: 0,
      });
    } else {
      that.setData({
        display: "block",
        display_order: "none",
        currentTab: 0,
        currentTab_one:0,
        currentTab_two:0,
        express_publish: [],
        express_accept: [],
        express_process: [],
        express_finish: [],
        used_publish: [],
        used_accept: [],
        used_process: [],
        used_finish: [],
      })
    }
  },
  user_login: function () {
    wx.navigateTo({
      url: '/pages/login/login',
    })
  },
  bindChange_one: function (e) {
    var that = this;
    // 判断用户现在在哪一个列表上
    that.setData({
      express_publish: [],
      express_accept: [],
      express_process: [],
      express_finish: [],
    })
    if (e.detail.current == 0) {
      that.getExpressByPublish();
    } else if (e.detail.current == 1) {
      that.getExpressByAccept();
    } else if (e.detail.current == 2) {
      that.getExpressByProcess();
    } else if (e.detail.current == 3) {
      that.getExpressByFinish();
    }
    that.setData({
      currentTab_one: e.detail.current
    });
  },
  bindChange_two: function (e) {
    var that = this;
    // 判断用户现在在哪一个列表上
    that.setData({
      used_publish: [],
      used_accept: [],
      used_process: [],
      used_finish: [],
    })
    if (e.detail.current == 0) {
      that.getUsedByPublish();
    } else if (e.detail.current == 1) {
      that.getUsedByAccept();
    } else if (e.detail.current == 2) {
      that.getUsedByProcess();
    } else if (e.detail.current == 3) {
      that.getUsedByFinish();
    }
    that.setData({
      currentTab_two: e.detail.current
    });
  },
  swichNav: function (e) {
    var that = this;
    if (this.data.currentTab === e.target.dataset.current) {
      return false;
    } else {
      that.setData({
        currentTab: e.target.dataset.current
      });
    }
  },
  swichNav_one: function (e) {
    var that = this;
    if (this.data.currentTab_one === e.target.dataset.current) {
      return false;
    } else {
      that.setData({
        currentTab_one: e.target.dataset.current
      });
    }
  },
  swichNav_two: function (e) {
    var that = this;
    if (this.data.currentTab_two === e.target.dataset.current) {
      return false;
    } else {
      that.setData({
        currentTab_two: e.target.dataset.current
      });
    }
  },

  getExpressByPublish: function () {
    var that = this;
    var publish_id = wx.getStorageSync('phone');
    wx.request({
      url: app.globalData.url + '/express/getByPublish',
      data: {
        publish_id: publish_id,
      },
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      success: function (res) {
        if (res.data.code == 200) {
          that.parseExpressData(res, "1", []);
        } else {
          console.log("publish 没有数据了")
        }
      }
    })
  },
  getUsedByPublish: function () {
    var that = this;
    var publish_id = wx.getStorageSync('phone');
    wx.request({
      url: app.globalData.url + '/used/getByPublish',
      data: {
        publish_id: publish_id,
      },
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      success: function (res) {
        if (res.data.code == 200) {
          that.parseUsedData(res, "1", []);
        } else {
          console.log("publish 没有数据了")
        }
      }
    })
  },
  getExpressByAccept: function () {
    var that = this;
    var accept_id = wx.getStorageSync('phone');
    wx.request({
      url: app.globalData.url + '/express/getByAccept',
      data: {
        accept_id: accept_id,
      },
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      success: function (res) {
        if (res.data.code == 200) {
          that.parseExpressData(res, "2", []);
        } else {
          console.log("accept 没有数据了")
        }
      }
    })
  },
  getUsedByAccept: function () {
    var that = this;
    var accept_id = wx.getStorageSync('phone');
    wx.request({
      url: app.globalData.url + '/used/getByAccept',
      data: {
        accept_id: accept_id,
      },
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      success: function (res) {
        if (res.data.code == 200) {
          that.parseUsedData(res, "2", []);
        } else {
          console.log("accept 没有数据了")
        }
      }
    })
  },
  getExpressByProcess: function () {
    var that = this;
    var phone = wx.getStorageSync('phone');
    wx.request({
      url: app.globalData.url + '/express/getByProcess',
      data: {
        phone: phone,
      },
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      success: function (res) {
        if (res.data.code == 200) {
          that.parseExpressData(res, "3", []);
        } else {
          console.log("process 没有数据了")
        }
      }
    })
  },
  getUsedByProcess: function () {
    var that = this;
    var phone = wx.getStorageSync('phone');
    wx.request({
      url: app.globalData.url + '/used/getByProcess',
      data: {
        phone: phone,
      },
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      success: function (res) {
        if (res.data.code == 200) {
          that.parseUsedData(res, "3", []);
        } else {
          console.log("process 没有数据了")
        }
      }
    })
  },
  getExpressByFinish: function () {
    var that = this;
    var phone = wx.getStorageSync('phone');
    wx.request({
      url: app.globalData.url + '/express/getByFinish',
      data: {
        phone: phone,
      },
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      success: function (res) {
        if (res.data.code == 200) {
          that.parseExpressData(res, "4", []);
        } else {
          console.log("finish 没有数据了")
        }
      }
    })
  },
  getUsedByFinish: function () {
    var that = this;
    var phone = wx.getStorageSync('phone');
    wx.request({
      url: app.globalData.url + '/used/getByFinish',
      data: {
        phone: phone,
      },
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      success: function (res) {
        if (res.data.code == 200) {
          that.parseUsedData(res, "4", []);
        } else {
          console.log("finish 没有数据了")
        }
      }
    })
  },
  parseUsedData: function (res, code, os) {
    var that = this;
    for (var i = 0; i < res.data.data.length; i++) {
      var date = res.data.data[i].usedDetail.used_publishtime;
      if (date != null) {
        date = utils.formatTime(new Date(date))
        res.data.data[i].usedDetail.used_publishtime = date;
      }
      os.push(res.data.data[i])
    }
    if (os.length === 0) {
      that.setData({
        used_size: 4
      })
    } else {
      if (os.length >= 4) {
        that.setData({
          used_size: os.length
        })
      } else {
        that.setData({
          used_size: 4
        })
      }
    }

    if (code === "1") {
      that.setData({
        used_publish: os,
      })
    } else if (code === "2") {
      that.setData({
        used_accept: os,
      })
    } else if (code === "3") {
      that.setData({
        used_process: os,
      })
    } else if (code === "4") {
      that.setData({
        used_finish: os,
      })
    }
  },

  parseExpressData: function (res, code, os) {
    var that = this;
    for (var i = 0; i < res.data.data.length; i++) {
      var date = res.data.data[i].expressDetail.express_publishtime;
      if (date != null) {
        date = utils.formatTime(new Date(date))
        res.data.data[i].expressDetail.express_publishtime = date;
      }
      os.push(res.data.data[i])
    }
    if (os.length === 0) {
      that.setData({
        express_size: 4
      })
    } else {
      if (os.length >= 4) {
        that.setData({
          express_size: os.length
        })
      } else {
        that.setData({
          express_size: 4
        })
      }
    }

    if (code === "1") {
      that.setData({
        express_publish: os,
      })
    } else if (code === "2") {
      that.setData({
        express_accept: os,
      })
    } else if (code === "3") {
      that.setData({
        express_process: os,
      })
    } else if (code === "4") {
      that.setData({
        express_finish: os,
      })
    }
  }
})