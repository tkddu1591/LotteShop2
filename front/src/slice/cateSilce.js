import {createSlice} from "@reduxjs/toolkit";

let cate1 = createSlice({
    name : 'cate1',
    initialState : null,
    reducers : {
        changeCate1(state,cate1Data){
            return  cate1Data.payload
        }
    }
})


let cate2 = createSlice({
    name : 'cate2',
    initialState : null,
    reducers : {
        changeCate2(state,cate2Data){
            return  cate2Data.payload
        }
    }
})
export const {changeCate1} = cate1.actions;
export const {changeCate2} = cate2.actions;
export {cate1,cate2}