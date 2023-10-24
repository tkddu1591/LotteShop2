import {createSlice} from "@reduxjs/toolkit";

let cate1 = createSlice({
    name : 'cate1',
    initialState : null,
    reducers : {
        changeCate1(state,cate1Data){
            return  cate1Data.payload
        },
        deleteCate1(state){
            return  null
        }
    }
})


let cate2 = createSlice({
    name : 'cate2',
    initialState : null,
    reducers : {
        changeCate2(state,cate2Data){
            return  cate2Data.payload
        },
        deleteCate2(state){
            return  null
        }
    }
})
let categoryNo = createSlice({
    name : 'categoryNo',
    initialState : null,
    reducers : {
        changeCategoryNo(state,action){
            return  action.payload
        }
    }
})

let cateNames = createSlice({
    name : 'cateNames',
    initialState : {},
    reducers : {
        changeCateNames(state,cateNamesData){
            return  cateNamesData.payload
        },
        deleteCateNames(state){
            return  null
        }
    }

})
export const {changeCate1, deleteCate1} = cate1.actions;
export const {changeCate2, deleteCate2} = cate2.actions;
export const {changeCateNames} = cateNames.actions;
export const {changeCategoryNo} = categoryNo.actions;
export {cate1,cate2, cateNames, categoryNo}