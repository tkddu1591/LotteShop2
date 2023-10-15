import {useNavigate} from "react-router-dom";

function Info({completeList, completeTotal}) {
    let navigate = useNavigate();
    return <>
        <article className="info">
            <h1>상품정보</h1>
            <table border="0">
                <tbody>

                    <tr>
                        <th>상품명</th>
                        <th>상품금액</th>
                        <th>할인금액</th>
                        <th>수량</th>
                        <th>주문금액</th>
                    </tr>
                    {Array.isArray(completeList) && completeList.map((item, index) => {
                        return <>
                            <tr key={index}>
                                <td>
                                    <article>
                                        <img src="https://via.placeholder.com/80x80" alt=""
                                             onClick={() => {
                                                 navigate(process.env.PUBLIC_URL + "/product/view?prodNo=" + item.prodNo)
                                             }} style={{cursor: 'pointer'}}/>
                                        <div>
                                            <h2><a onClick={() => {
                                                navigate(process.env.PUBLIC_URL + "/product/view?prodNo=" + item.prodNo)
                                            }} style={{cursor: 'pointer'}}>상품명</a></h2>
                                            <p>상품설명</p>
                                        </div>
                                    </article>
                                </td>
                                <td>{item.price.toLocaleString()}원</td>
                                <td>{item.discount !== 0 ? item.discount.toLocaleString() : '-'}</td>
                                <td>{item.count}</td>
                                <td>{item.total.toLocaleString()}</td>
                            </tr>
                        </>
                    })}
                    <tr className="total">
                        <td colSpan="4"></td>
                        <td>
                            <table border="0">
                                <tbody>
                                    <tr>
                                        <td>총 상품금액</td>
                                        <td><span>{completeTotal.price}</span>원</td>
                                    </tr>
                                    {completeTotal.ordDiscount + completeTotal.usedPoint !== 0 ?
                                        <tr>
                                            <td>총 할인금액</td>
                                            <td>
                                                <span>-{(completeTotal.ordDiscount + completeTotal.usedPoint).toLocaleString()}</span>원
                                            </td>
                                        </tr> : null}
                                    {completeTotal.ordDelivery !== 0 ?
                                        <tr>
                                            <td>배송비</td>
                                            <td><span>{completeTotal.ordDelivery}</span>원</td>
                                        </tr> : null}
                                    <tr>
                                        <td>총 결제금액</td>
                                        <td><span>{completeTotal.ordTotPrice}</span>원</td>
                                    </tr>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                </tbody>
            </table>

        </article>
    </>
}
export default Info