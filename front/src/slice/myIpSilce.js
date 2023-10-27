import {createSlice} from "@reduxjs/toolkit";

let myIp = createSlice({
    name : 'myIp',
    initialState : '',
    reducers : {
        insertMyIp:(state, action) => {
            return action.payload;
        },
    }
})

export const {insertMyIp} = myIp.actions;
export {myIp}