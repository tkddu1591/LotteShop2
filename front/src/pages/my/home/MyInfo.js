import React from "react";

function MyInfo({member, setDivName}) {
    return <>

        <article className="myinfo">
            <h3>확인해주세요!</h3>

            <div>
                <div className="address" style={{marginTop: '-5px'}}>
                    <span>기본 배송지설정</span>
                    <a onClick={()=>{setDivName('info')}} className="setting">변경</a>
                    <p style={{marginTop: '10px'}}>
                        <span>{member.addr1}</span><br/>
                        <span>{member.addr2}</span><br/>
                        {member.changeDate && <>
                            (최종수정일 < span> {member.changeDate.substring(0, 10)}< /span>)</>
                        }

                    </p>
                </div>
                <div className="email">
                    <span>email 설정</span>
                    <a onClick={()=>{setDivName('info')}} className="setting">변경</a>
                    <p>
                        <span>{member.email}</span><br/>
                        {member.changeDate && <>
                            (최종수정일 < span> {member.changeDate.substring(0, 10)}< /span>)</>
                        }
                    </p>
                </div>
                <div className="hp">
                    <span>휴대폰 설정</span>
                    <a onClick={()=>{setDivName('info')}} className="setting">변경</a>
                    <p>
                        <span>{member.hp}</span><br/>
                        {member.changeDate && <>
                            (최종수정일 < span> {member.changeDate.substring(0, 10)}< /span>)</>
                        }
                    </p>
                </div>
            </div>


        </article>
    </>
}

export default MyInfo;