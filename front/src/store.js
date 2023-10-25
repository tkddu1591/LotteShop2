import {configureStore} from "@reduxjs/toolkit";
import {cate1, cate2, cateNames, categoryNo} from "./slice/cateSilce"
import {banner} from "./slice/bannerSilce";
import {orderProducts, orderTotal} from "./slice/orderSilce";
import {member} from "./slice/memberSlice";
import {myIp} from "./slice/myIpSilce";

export default configureStore({
    reducer: {
        cate1 : cate1.reducer,
        cate2 : cate2.reducer,
        cateNames : cateNames.reducer,
        categoryNo : categoryNo.reducer,
        banner : banner.reducer,
        orderProducts : orderProducts.reducer,
        orderTotal : orderTotal.reducer,
        member : member.reducer,
        myIp : myIp.reducer,
    }
})