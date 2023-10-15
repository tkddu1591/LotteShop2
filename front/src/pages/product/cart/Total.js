function Total({total}) {
    return <>
        {total.totalCount !==0 ? <div className="total" style={{height:'auto'}}>
                <h2>전체합계</h2>
                <table border="0">
                    <tbody>
                        <tr>
                            <td>상품수</td>
                            <td>{total.totalCount}</td>
                        </tr>
                        <tr>
                            <td>상품금액</td>
                            <td>{total.totalProductPrice.toLocaleString()}</td>
                        </tr>
                        {total.totalDiscountPrice !== 0 ?
                            <tr>
                                <td>할인금액</td>
                                <td>- {total.totalDiscountPrice.toLocaleString()}</td>
                            </tr>
                            : null
                        }
                        {total.totalDelivery !== 0 ?
                            <tr>
                                <td>배송비</td>
                                <td>{total.totalDelivery === 0 ? '-' : total.totalDelivery.toLocaleString()}</td>
                            </tr>
                            : null}
                        {total.totalPoint !== 0 ?
                            <tr>
                                <td>포인트 적립</td>
                                <td style={{color:'dodgerblue'}}> {total.totalPoint.toLocaleString()} P</td>
                            </tr>
                            : null}
                        <tr>
                            <td>전체주문금액</td>
                            <td>{total.totalOrderPrice.toLocaleString()}</td>
                        </tr>
                    </tbody>
                </table>

                <input type="submit" name="" value="주문하기"/>
            </div>:
            <div className="total" style={{height:'auto'}}>
                <h2>전체합계</h2>
                <tabele border="0">
                    <tbody>
                        <tr>선택하신 상품이 없습니다</tr>
                    </tbody>
                </tabele>
            </div>}
    </>
}

export default Total;