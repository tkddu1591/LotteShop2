import axios from "axios";
import {useNavigate} from "react-router-dom";

function Receipt({orderEnd, usePoint, orderProducts}) {
    let navigate = useNavigate();
    return <>
        <div className="final" style={{height: 'auto'}}>
            <h2>최종결제 정보</h2>
            <table border="0">
                <tbody>
                    <tr>
                        <td>상품수</td>
                        <td>{orderEnd.ordPrice}</td>
                    </tr>
                    <tr>
                        <td>상품금액</td>
                        <td>{orderEnd.ordPrice !== 0 ? orderEnd.ordPrice.toLocaleString() : ''}</td>
                    </tr>

                    {orderEnd.ordDelivery !== 0 ?
                        <tr>
                            <td>배송비</td>
                            <td>{orderEnd.ordDelivery === 0 ? '-' : orderEnd.ordDelivery.toLocaleString()}</td>
                        </tr>
                        : null}
                    {orderEnd.orderDiscount !== 0 ?
                        <tr>
                            <td>할인금액</td>
                            <td>- {orderEnd.ordDiscount.toLocaleString()}</td>
                        </tr>
                        : null
                    }
                    {orderEnd.usedPoint !== 0 ?
                        <tr>
                            <td>포인트 할인</td>
                            <td> - {orderEnd.usedPoint} </td>
                        </tr>
                        : null}
                    {orderEnd.savePoint !== 0 ?
                        <tr>
                            <td>포인트 적립</td>
                            <td style={{color: 'dodgerblue'}}> {orderEnd.savePoint.toLocaleString()} P</td>
                        </tr>
                        : null}
                    <tr>
                        <td>전체주문금액</td>
                        <td>{orderEnd.ordTotTotal.toLocaleString()}</td>
                    </tr>
                </tbody>
            </table>
            <input type="button" value="결제하기"
                   onClick={async () => {
                       console.log(orderEnd.recipHp.length)
                       if (orderEnd.recipHp.length !== 13) {
                           alert('휴대폰 번호를 확인해주세요')
                       } else if (orderEnd.ordPayment === 0) {
                           alert('결제방식을 선택해주세요')
                       } else {
                           console.log(orderProducts)
                           await axios.post('/product/order/total', orderEnd,
                               {
                                   headers: {
                                       'Content-Type': 'application/json',
                                   }
                               }).catch((error) => {
                               console.error(error)
                           })
                           await axios.post('/product/order/products', orderProducts,
                               {
                                   headers: {
                                       'Content-Type': 'application/json',
                                   }
                               }).catch((error) => {
                               console.error(error)
                           })
                           await axios.delete('/product/cart/all?uid='+orderEnd.ordUid, {
                               headers: {'Content-Type': 'application/json'}
                           })
                               .catch((error) => {
                                   console.error(error);
                               });
                           await navigate(process.env.PUBLIC_URL + "/product/complete")
                       }
                   }}
            />
        </div>
    </>
}

export default Receipt;