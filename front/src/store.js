import {configureStore} from "@reduxjs/toolkit";
import {cate1, cate2, cateNames, categoryNo} from "./slice/cateSilce"
export default configureStore({
    reducer: {
        cate1 : cate1.reducer,
        cate2 : cate2.reducer,
        cateNames : cateNames.reducer,
        categoryNo : categoryNo.reducer
    }
})