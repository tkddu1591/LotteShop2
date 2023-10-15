import {useEffect, useState} from "react";
import axios from "axios";
import CartList from "./CartList";
import Total from "./Total";
function Cart() {

    let [cartDataList, setCartDataList] = useState([]);
    let [selectedCartList, setSelectedCartList] = useState([]);

    useEffect(() => {
        axios.get('/product/cart', {
            params: {
                uid: 'user'
            }
        }).then(res => {
            setCartDataList(res.data)
        })
    }, []);
    useEffect(() => {
        setSelectedCartList(cartDataList)
    }, [cartDataList]);

    let [total, setTotal] = useState({
        totalCount: 10,
        totalProductPrice: 10,
        totalDiscountPrice: 10,
        totalDelivery: 10,
        totalPoint: 10,
        totalOrderPrice: 10,
    })
    useEffect(() => {

        if (selectedCartList.length !== 0) {
            //상품금액 총액
            const totalProductPrice = selectedCartList.reduce((total, item) => {
                return total + (item.price * item.count);
            }, 0);
            //할인받고 내야하는 금액 합계
            let totalDiscount = selectedCartList.map(item => item.total).reduce((a, b) => a + b)
            //배달금 합계
            let delivery = selectedCartList.map(item => item.delivery).reduce((a, b) => a + b)
            //할인금액
            let discountPrice = totalProductPrice - totalDiscount;

            setTotal({
                totalCount: selectedCartList.length,
                totalProductPrice: totalProductPrice,
                totalDiscountPrice: discountPrice,
                totalDelivery: delivery,
                totalPoint: selectedCartList.map(item => item.point).reduce((a, b) => a + b),
                totalOrderPrice: totalDiscount + delivery,
            })
        } else {
            setTotal({
                totalCount: 0,
                totalProductPrice: 0,
                totalDiscountPrice: 0,
                totalDelivery: 0,
                totalPoint: 0,
                totalOrderPrice: 0,
            })
        }
    }, [selectedCartList])


    console.log(total)
    console.log(selectedCartList)

    return <>

        <CartList cartDataList={cartDataList}
                  setSelectedCartList={setSelectedCartList}
                  selectedCartList={selectedCartList}
        />

        <input type="button" name="del" value="선택삭제"/>

        <Total total={total}/>

    </>

}


export default Cart;