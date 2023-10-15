import {createSlice} from "@reduxjs/toolkit";

let cartProduct = createSlice({
    name : 'cartProduct',
    initialState : [],
    reducers : {
        insertFromCart(state,action){
            return [...state, action.payload]
        },
        deleteFromCart: (state, action) => {
            const productIdToDelete = action.payload;
            return state.filter(product => product.id !== productIdToDelete);
        },
        deleteAllFromCart: (state, action) => {
            return [];
        }
    }
})
export const {insertFromCart, deleteFromCart, deleteAllFromCart} = cartProduct.actions;
export {cartProduct}
