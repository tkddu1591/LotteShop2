import {useSelector} from "react-redux";
import OrderProducts from "./OrderProducts";
import Receipt from "./Receipt";
import React, {useEffect, useState} from "react";
import Payment from "./Payment";
import Discount from "./Discount";
import Delivery from "./Delivery";
import Alert from "./Alert";
import Error from "./Error";

function Order() {

    let orderTotal = useSelector((state) => state.orderTotal);
    let orderProducts = useSelector((state) => state.orderProducts);
    let newOrderProducts = [];
    let [newOrderTotal, setNewOrderTotal] = useState(orderTotal);
    let [usePoint, setUsePoint] = useState(0);
    let member = useSelector((state) => state.member);
    let [orderEnd, setOrderEnd] = useState({
        ordCount: newOrderTotal.totalCount,
        ordPrice: newOrderTotal.totalProductPrice,
        ordDiscount: newOrderTotal.totalDiscountPrice,
        ordDelivery: newOrderTotal.totalDelivery,
        savePoint: newOrderTotal.totalPoint,
        ordTotPrice: newOrderTotal.totalOrderPrice,
        ordComplete: 1,
        ordPayment: 0,
        usedPoint: 0,
        recipName: member.name,
        recipHp: member.hp,
        recipAddr1: member.addr1,
        recipAddr2: member.addr2,
        recipZip: member.zip,
        ordUid: member.uid,
    })
    const [formattedPhoneNumber, setFormattedPhoneNumber] = useState(
        orderEnd.recipHp
    );
    const changeOrderEnd = (key, value) => {
        setOrderEnd((orderTotal) => {
            let newOrderTotal = {...orderTotal};
            newOrderTotal[key] = value;
            return newOrderTotal;
        });
    };
    if (orderProducts !== newOrderProducts)
        for (let data of orderProducts) {
            let copy = newOrderProducts
            newOrderProducts = ([...copy, {
                count: data.count,
                delivery: data.delivery,
                discount: data.discount,
                point: data.point,
                price: data.price,
                prodNo: data.prodNo,
                total: data.total,
            }])
        }

    if (member.uid !== '' && orderEnd.ordCount !== 0)
        return <>
            <OrderProducts orderProducts={orderProducts}></OrderProducts>
            <Receipt orderEnd={orderEnd} orderProducts={newOrderProducts} member={member}></Receipt>
            <Delivery setOrderEnd={setOrderEnd}
                      member={member}
                      changeOrderEnd={changeOrderEnd}
                      orderEnd={orderEnd}
                      formattedPhoneNumber={formattedPhoneNumber}
                      setFormattedPhoneNumber={setFormattedPhoneNumber}
            ></Delivery>
            <Discount usePoint={usePoint}
                      changeOrderEnd={changeOrderEnd}
                      member={member}
                      newOrderTotal={newOrderTotal}
                      setUsePoint={setUsePoint}></Discount>
            <Payment changeOrderEnd={changeOrderEnd} orderEnd={orderEnd}></Payment>

            <Alert></Alert>
        </>
    else
        return <Error></Error>
}


export default Order;