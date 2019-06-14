// pages/user/publishUsed/publishUsed.js

var app = getApp();

Page({

  /**
   * 页面的初始数据
   */
  data: {
    photos:"",
    trueFileName:"",
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

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
  chooseImg: function () {
    var that = this
    wx.chooseImage({
      count: 1, // 默认9
      sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
      sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
      success: function (res) {
        // 返回选定照片的本地文件路径列表，tempFilePath可以作为img标签的src属性显示图片
        var tempFilePaths = res.tempFilePaths
        that.setData({
          photos: tempFilePaths
        })
        console.log(that.data.photos)
      }
    })
  },

  uploadImg: function () {
    var that = this
    wx.uploadFile({
      url: app.globalData.url+'/used/upload', 
      filePath: that.data.photos[0],
      name: 'file',
      formData: {
      },
      success: function (res) {
        //do something
        that.setData({
          trueFileName: res.data,
        })
        wx.showModal({
          content: "上传成功",
          showCancel: false,
          confirmText: "确定"
        })
      },
      fail:function(res){
        wx.showModal({
          content: "请选择图片",
          showCancel: false,
          confirmText: "确定"
        })
      }
    })
  },
  publishUsed: function(e){
    console.log(e);
    var publish_id = wx.getStorageSync('phone');
    var used_title = e.detail.value.order_used_title;
    var used_message = e.detail.value.order_used_message;
    var used_contact = e.detail.value.order_used_contact;
    var used_reward = e.detail.value.order_used_reward;
    var used_note = e.detail.value.order_used_note;
    var trueFileName = this.data.trueFileName;
    console.log(trueFileName);

    if (used_title == "" || used_message == "" || used_contact == "" || used_reward == ""){
      wx.showModal({
        content: "请填写完整信息",
        showCancel: false,
        confirmText: "确定"
      })
    }else{
      if (trueFileName) {
        wx.request({
          url: app.globalData.url + '/used/publish',
          header: {
            "Content-Type": "application/x-www-form-urlencoded"
          },
          data: {
            publish_id: publish_id,
            used_title: used_title,
            used_message: used_message,
            used_contact: used_contact,
            used_price: used_reward,
            used_note: used_note,
            used_img: trueFileName,
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
        wx.showModal({
          content: "请上传图片",
          showCancel: false,
          confirmText: "确定"
        })
      }
    }

  }

})