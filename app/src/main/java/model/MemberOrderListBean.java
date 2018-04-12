package model;

import android.database.Observable;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by hechao on 12/4/13.
 */
@SuppressWarnings("serial")
public class MemberOrderListBean extends BaseObservable implements Serializable {

    private int currentPage;
    private int totalPages;
    private int pageSize;
    public ArrayList<OrderBean> userOrders;

    public static class OrderBean implements Serializable {
        // 0隐藏 1显示
        public String canTH, canHH;//
        public String aliasCode;// 外部订单号
        public String orderId; // 内部订单号
        public String paySerialNumber;// 第三方支付订单流水号
        public String createTime, acceptName, order_states, needPay, givePoints, orderStateId,
				despatchOrderNo;
        public String deliveryerNameCh, deliveryerNameEn, deliveryUrl, payModeId, emoneyPay,
				totalPay, orderAmt;
        public String orderTime, mobilePhone, address, orderSign, merchantId, fare;
        public String couponPay;// 优惠金额总计
        public String productAmt;// 商品金额总计
        public String isSign;// 是否已签收
        public int delaySignCount;// 延时签收次数。最大为1.表示延迟10天。0为未延时签收
        public String shipmentDate;// 发货日期
        public ArrayList<PayInfo> payInfoList;
        public ArrayList<OrderProduct> orderProducts;
        public ArrayList<Delivery> deliveryList;
        public int isFlag;// 是否整单售后1能0不能
        public int isPart;// 能否整单售后
        public int gold;// 0不是金币订单 1是金币订单
        public int customerServiceState;// 是否可以售后 1可以 2不可以
        public int moneyBackState;// 是否可以退款 1可以 不可以
        public int discountCouponState;// 是否使用优惠券
        public ArrayList<applyOrderItems> applyOrderItems;// 售后信息集合
        public String area;// 收货地区名称；
        public String areaPath;// 收货地区path
        private int orderType; //34礼包订单
        public String url="https://goss2.vcg.com/creative/vcg/800/new/VCG41N945269902.jpg";




        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getOrderType() {
            return orderType;
        }

        public void setOrderType(int orderType) {
            this.orderType = orderType;
        }


        public String getCanTH() {
            return canTH;
        }

        public void setCanTH(String canTH) {
            this.canTH = canTH;
        }

        public String getCanHH() {
            return canHH;
        }

        public void setCanHH(String canHH) {
            this.canHH = canHH;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getAreaPath() {
            return areaPath;
        }

        public void setAreaPath(String areaPath) {
            this.areaPath = areaPath;
        }

        public int getIsPart() {
            return isPart;
        }

        public void setIsPart(int isPart) {
            this.isPart = isPart;
        }

        public ArrayList<applyOrderItems> getApplyOrderItems() {
            return applyOrderItems;
        }

        public void setApplyOrderItems(ArrayList<applyOrderItems> applyOrderItems) {
            this.applyOrderItems = applyOrderItems;
        }

        public static class applyOrderItems implements Serializable {
            private String checkAmount;// 选择的个数
            private int applyId;
            private String applyName;
            private int applyIsPresent;
            private int applyAmount;
            private int applyObjId;
            private String applyImgPath;// 图片链接

            public String getCheckAmount() {
                return checkAmount;
            }

            public void setCheckAmount(String checkAmount) {
                this.checkAmount = checkAmount;
            }

            public int getApplyId() {
                return applyId;
            }

            public void setApplyId(int applyId) {
                this.applyId = applyId;
            }

            public String getApplyName() {
                return applyName;
            }

            public void setApplyName(String applyName) {
                this.applyName = applyName;
            }

            public int getApplyIsPresent() {
                return applyIsPresent;
            }

            public void setApplyIsPresent(int applyIsPresent) {
                this.applyIsPresent = applyIsPresent;
            }

            public int getApplyAmount() {
                return applyAmount;
            }

            public void setApplyAmount(int applyAmount) {
                this.applyAmount = applyAmount;
            }

            public int getApplyObjId() {
                return applyObjId;
            }

            public void setApplyObjId(int applyObjId) {
                this.applyObjId = applyObjId;
            }

            public String getApplyImgPath() {
                return applyImgPath;
            }

            public void setApplyImgPath(String applyImgPath) {
                this.applyImgPath = applyImgPath;
            }

        }

        public int getMoneyBackState() {
            return moneyBackState;
        }

        public void setMoneyBackState(int moneyBackState) {
            this.moneyBackState = moneyBackState;
        }

        public int getDiscountCouponState() {
            return discountCouponState;
        }

        public void setDiscountCouponState(int discountCouponState) {
            this.discountCouponState = discountCouponState;
        }

        public int getCustomerServiceState() {
            return customerServiceState;
        }

        public int getGold() {
            return gold;
        }

        public void setGold(int gold) {
            this.gold = gold;
        }

        public void setGlobal(boolean isGlobal) {
            this.isGlobal = isGlobal;
        }

        public void setCustomerServiceState(int customerServiceState) {
            this.customerServiceState = customerServiceState;
        }

        //
        public boolean isGlobal;

        public int getIsFlag() {
            return isFlag;
        }

        public void setIsFlag(int isFlag) {
            this.isFlag = isFlag;
        }

        public String identityId;

        public boolean getIsGlobal() {
            return isGlobal;
        }

        public void setIsGlobal(boolean isGlobal) {
            this.isGlobal = isGlobal;
        }

        public String getIdentityId() {
            return identityId;
        }

        public void setIdentityId(String identityId) {
            this.identityId = identityId;
        }

        public String getAliasCode() {
            return aliasCode;
        }

        public void setAliasCode(String aliasCode) {
            this.aliasCode = aliasCode;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getPaySerialNumber() {
            return paySerialNumber;
        }

        public void setPaySerialNumber(String paySerialNumber) {
            this.paySerialNumber = paySerialNumber;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getAcceptName() {
            return acceptName;
        }

        public void setAcceptName(String acceptName) {
            this.acceptName = acceptName;
        }

        public String getOrder_states() {
            return order_states;
        }

        public void setOrder_states(String order_states) {
            this.order_states = order_states;
        }

        public String getNeedPay() {
            return needPay;
        }

        public void setNeedPay(String needPay) {
            this.needPay = needPay;
        }

        public String getGivePoints() {
            return givePoints;
        }

        public void setGivePoints(String givePoints) {
            this.givePoints = givePoints;
        }

        public String getOrderStateId() {
            return orderStateId;
        }

        public void setOrderStateId(String orderStateId) {
            this.orderStateId = orderStateId;
        }

        public String getDespatchOrderNo() {
            return despatchOrderNo;
        }

        public void setDespatchOrderNo(String despatchOrderNo) {
            this.despatchOrderNo = despatchOrderNo;
        }

        public String getDeliveryerNameCh() {
            return deliveryerNameCh;
        }

        public void setDeliveryerNameCh(String deliveryerNameCh) {
            this.deliveryerNameCh = deliveryerNameCh;
        }

        public String getDeliveryerNameEn() {
            return deliveryerNameEn;
        }

        public void setDeliveryerNameEn(String deliveryerNameEn) {
            this.deliveryerNameEn = deliveryerNameEn;
        }

        public String getDeliveryUrl() {
            return deliveryUrl;
        }

        public void setDeliveryUrl(String deliveryUrl) {
            this.deliveryUrl = deliveryUrl;
        }

        public ArrayList<Delivery> getDeliveryList() {
            return deliveryList;
        }

        public void setDeliveryList(ArrayList<Delivery> deliveryList) {
            this.deliveryList = deliveryList;
        }

        public String getPayModeId() {
            return payModeId;
        }

        public void setPayModeId(String payModeId) {
            this.payModeId = payModeId;
        }

        public String getEmoneyPay() {
            return emoneyPay;
        }

        public void setEmoneyPay(String emoneyPay) {
            this.emoneyPay = emoneyPay;
        }

        public String getTotalPay() {
            return totalPay;
        }

        public void setTotalPay(String totalPay) {
            this.totalPay = totalPay;
        }

        public String getOrderAmt() {
            return orderAmt;
        }

        public void setOrderAmt(String orderAmt) {
            this.orderAmt = orderAmt;
        }

        public String getOrderTime() {
            return orderTime;
        }

        public void setOrderTime(String orderTime) {
            this.orderTime = orderTime;
        }

        public String getMobilePhone() {
            return mobilePhone;
        }

        public void setMobilePhone(String mobilePhone) {
            this.mobilePhone = mobilePhone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getOrderSign() {
            return orderSign;
        }

        public void setOrderSign(String orderSign) {
            this.orderSign = orderSign;
        }

        public String getMerchantId() {
            return merchantId;
        }

        public void setMerchantId(String merchantId) {
            this.merchantId = merchantId;
        }

        public String getFare() {
            return fare;
        }

        public void setFare(String fare) {
            this.fare = fare;
        }

        public String getCouponPay() {
            return couponPay;
        }

        public void setCouponPay(String couponPay) {
            this.couponPay = couponPay;
        }

        public String getProductAmt() {
            return productAmt;
        }

        public void setProductAmt(String productAmt) {
            this.productAmt = productAmt;
        }

        public String getIsSign() {
            return isSign;
        }

        public void setIsSign(String isSign) {
            this.isSign = isSign;
        }

        public ArrayList<PayInfo> getPayInfoList() {
            return payInfoList;
        }

        public void setPayInfoList(ArrayList<PayInfo> payInfoList) {
            this.payInfoList = payInfoList;
        }

        public ArrayList<OrderProduct> getOrderProducts() {
            return orderProducts;
        }

        public void setOrderProducts(ArrayList<OrderProduct> orderProducts) {
            this.orderProducts = orderProducts;
        }

        public String getShipmentDate() {
            return shipmentDate;
        }

        public void setShipmentDate(String shipmentDate) {
            this.shipmentDate = shipmentDate;
        }

        public int getDelaySignCount() {
            return delaySignCount;
        }

        public void setDelaySignCount(int delaySignCount) {
            this.delaySignCount = delaySignCount;
        }

    }

    public static class PayInfo implements Serializable {
        private static final long serialVersionUID = 1L;
        public String payAmount, payState, payModeId, payModeName;

        //

        public String getPayAmount() {
            return payAmount;
        }

        public void setPayAmount(String payAmount) {
            this.payAmount = payAmount;
        }

        public String getPayState() {
            return payState;
        }

        public void setPayState(String payState) {
            this.payState = payState;
        }

        public String getPayModeId() {
            return payModeId;
        }

        public void setPayModeId(String payModeId) {
            this.payModeId = payModeId;
        }

        public String getPayModeName() {
            return payModeName;
        }

        public void setPayModeName(String payModeName) {
            this.payModeName = payModeName;
        }

        public static long getSerialversionuid() {
            return serialVersionUID;
        }
    }

    /**
     * 物流信息
     */
    public static class Delivery implements Serializable {
        private static final long serialVersionUID = 1L;
        // 配送时间、配送内容
        public String time, context;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getContext() {
            return context;
        }

        public void setContext(String context) {
            this.context = context;
        }
    }

    public static class OrderProduct implements Serializable {
        private static final long serialVersionUID = 1L;
        public String articleTitle, orderAmount, articleId, articlePrice, articlePicPath, selectAmount, itemId;
        public String prefix, postfix;

        public String getPrefix() {
            return prefix;
        }

        public void setPrefix(String prefix) {
            this.prefix = prefix;
        }

        public String getPostfix() {
            return postfix;
        }

        public void setPostfix(String postfix) {
            this.postfix = postfix;
        }

        public String getArticleTitle() {
            return articleTitle;
        }

        public String getItemId() {
            return itemId;
        }

        public void setItemId(String itemId) {
            this.itemId = itemId;
        }

        public String getSelectAmount() {
            return selectAmount;
        }

        public void setSelectAmount(String selectAmount) {
            this.selectAmount = selectAmount;
        }

        public void setArticleTitle(String articleTitle) {
            this.articleTitle = articleTitle;
        }

        public String getOrderAmount() {
            return orderAmount;
        }

        public void setOrderAmount(String orderAmount) {
            this.orderAmount = orderAmount;
        }

        public String getArticleId() {
            return articleId;
        }

        public void setArticleId(String articleId) {
            this.articleId = articleId;
        }

        public String getArticlePrice() {
            return articlePrice;
        }

        public void setArticlePrice(String articlePrice) {
            this.articlePrice = articlePrice;
        }

        public String getArticlePicPath() {
            return articlePicPath;
        }

        public void setArticlePicPath(String articlePicPath) {
            this.articlePicPath = articlePicPath;
        }

        public static long getSerialversionuid() {
            return serialVersionUID;
        }
    }

    // /////////////////////////////////////

    public ArrayList<OrderBean> getUserOrders() {
        return userOrders;
    }

    public void setUserOrders(ArrayList<OrderBean> userOrders) {
        this.userOrders = userOrders;
    }

    @Bindable
    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
//		notifyPropertyChanged(BR.currentPage);
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPage) {
        this.totalPages = totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }



}
