import React from "react";
import axios from "axios";

function PopReceive({setPopup, item}) {
    return <>
        <div id="popReceive" className="popup">
            <div>
                <nav>
                    <h1>수취확인</h1>
                    <button className="btnClose"
                            onClick={() => {
                                setPopup('')
                            }}>확인>X
                    </button>
                </nav>
                <section>
                    <p>
                        상품을 잘 받으셨나요?<br/>
                        상품을 받으셨으면 수취확인을 눌러 구매확정을 진행하세요.<br/>
                        구매확정 후 포인트를 지급해 드립니다.
                    </p>

                    <div>
                        <button className="btnPositive btnConfirm" style={{
                            width: '80px',
                            height: '30px',
                        }}
                                onClick={() => {
                                    axios.post(`${process.env.REACT_APP_API_ROOT}/product/order/complete`, {
                                        ordNo: item.ordNo,
                                        ordComplete: 5
                                    }).then(() => {
                                        alert('수취확인이 완료되었습니다.')
                                        setPopup('')
                                    })
                                        .catch((err) => {

                                        })
                                }}>확인
                        </button>
                        <button className="btnNegative btnCancel" style={{
                            marginLeft: '10px',
                            width: '80px',
                            height: '30px',
                        }}
                                onClick={() => {
                                    setPopup('')
                                }}
                        >취소
                        </button>
                    </div>
                </section>
            </div>
        </div>
    </>
}

export default PopReceive;