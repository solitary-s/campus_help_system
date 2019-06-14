
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    publish_id: "",
    orderType: 101,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.data.publish_id = wx.getStorageSync('phone');
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
  publishExpress: function (e) {
    var that = this;
    var order_express_campany = e.detail.value.order_express_campany;
    var order_express_message = e.detail.value.order_express_message;
    var order_express_phone = e.detail.value.order_express_phone;
    var order_express_site = e.detail.value.order_express_site;
    var order_express_reward = e.detail.value.order_express_reward;
    var order_express_contact = e.detail.value.order_express_contact;
    var order_express_note = e.detail.value.order_express_note;
    

    if (order_express_campany == "" || order_express_message == "" || order_express_phone == "" || order_express_site == "" || 
      order_express_reward == "" || order_express_contact == "") {
      wx.showModal({
        content: '请输入完整信息！',
        success: function (res) {
          if (res.confirm) {
            console.log('用户点击确定')
          }
        }
      })
    } else {
      if (that.checkPhoneNum(order_express_phone) && that.checkPhoneNum(order_express_contact) ) {
        wx.request({
          url: app.globalData.url + '/express/publish',
          header: {
            "Content-Type": "application/x-www-form-urlencoded"
          },
          data: {
            publish_id: that.data.publish_id,
            express_campany: order_express_campany,
            express_message: order_express_message,
            express_phone: order_express_phone,
            express_reward: order_express_reward,
            express_site: order_express_site,
            express_contact: order_express_contact,
            express_note: order_express_note,
          },
          method: 'POST',
          success: function (res) {
            if (res.data.code == '200') { //没有更多的时候
              wx.showModal({
                content: res.data.message,
                showCancel: false,
                confirmText: "确定"
              })
              wx.switchTab({
                url: '/pages/order/order',
              })
            }
          }
        })
      } else {
        wx.showModal({ //失败弹窗
          content: "联系电话输入错误",
          showCancel: false,
          confirmText: "确定"
        })
      }
    }
  },

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

})