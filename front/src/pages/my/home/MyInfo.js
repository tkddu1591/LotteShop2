import React from "react";

function MyInfo() {
    return <>

        <article className="myinfo">
            <h3>확인해주세요!</h3>

            <div>
                <div className="address">
                    <span>기본 배송지설정</span>
                    <a href="#" className="setting">변경</a>
                </div>
                <div className="email">
                    <span>email 설정</span>
                    <a href="#" className="setting">변경</a>
                    <p>
                        <span>abc123@gmail.com</span><br/>
                        (최종수정일 <span>2021-12-10</span>)
                    </p>
                </div>
                <div className="hp">
                    <span>휴대폰 설정</span>
                    <a href="#" className="setting">변경</a>
                    <p>
                        <span>abc123@gmail.com</span><br/>
                        (최종수정일 <span>2021-12-10</span>)
                    </p>
                </div>
            </div>


        </article>
    </>
}

export default MyInfo;