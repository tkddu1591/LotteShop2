import React, {useEffect, useLayoutEffect} from "react";
import {changeDTO} from "../../../store/changeDTO";
import axios from "axios";
import {API_BASE_URL} from "../../../App";
import {useNavigate} from "react-router-dom";

function QnaPopup({setPopup, item, member}) {
    let navigate = useNavigate();
    let [qnaCate, setQnaCate] = React.useState()
    let [qnaType, setQnaType] = React.useState()
    let [qna, setQna] = React.useState({
        orderItemId: item.orderItemId,
        title: '',
        content: '',
        email: member.email,
        cate: '',
        type: '',
        writer: member.uid
    })
    console.log(qna)
    useLayoutEffect(() => {
        axios.get(`${API_BASE_URL}/cs/cateAll`).then((res) => {
            setQnaCate(res.data)
        }).catch((err) => {
            console.log(err)
        })
    }, []);
    useEffect(() => {
        if (qna.cate !== '' && qna.cate !== '1차 분류') {
            axios.get(`${API_BASE_URL}/cs/typeByCate?cate=` + qna.cate).then((res) => {
                console.log(res.data)
                setQnaType(res.data)
            }).catch((err) => {
                console.log(err)
            })
        }
    }, [qna.cate]);

    function firstClassification(item) {
        if (item !== undefined) {
            return <>
                <option value='' key="1차분류">1차 분류</option>
                {item.map((value, index) => {
                    if (value.cate === 'cancel' || value.cate === 'delivery' || value.cate === 'order' || value.cate === 'safe')
                        return <option value={value.cate} key={item.cate}>{value.cateName}</option>
                })}
            </>
        }
    }

    function secondaryClassification(item) {

        if (item !== undefined && qna.cate !== '') {

            return <>
                <option value=''>2차 분류</option>
                {item.map((value, index) => {
                    return <option value={value.type} key={value.type}>{value.typeName}</option>
                })}
            </>
        } else {
            return <>
                <option value=''>2차 분류</option>
            </>
        }

    }

    return <>
        <div id="popSeller" className="popup">
            <div>
                <nav>
                    <h1>판매자 정보</h1>
                    <button className="btnClose" onClick={() => {
                        setPopup('')
                    }}>X
                    </button>
                </nav>
                <section>
                    <table border="0" style={{width: '600px'}}>
                        <tbody>
                            <tr>
                                <th>주문번호</th>
                                <td>
                                    {item.ordNo}
                                </td>
                            </tr>
                            <tr>
                                <th>문의 종류</th>
                                <td>
                                    <select onChange={(e) => {
                                        changeDTO(setQna, 'cate', e.target.value)
                                    }}>
                                        {firstClassification(qnaCate)}
                                    </select>
                                    <select onChange={(e) => {
                                        changeDTO(setQna, 'type', e.target.value)
                                    }}>
                                        {secondaryClassification(qnaType)}
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <th>Email</th>
                                <td>
                                    <input type="text" placeholder="이메일을 입력해주세요." required
                                           value={qna.email} onChange={(e) => {
                                        changeDTO(setQna, 'email', e.target.value)
                                    }}></input>
                                </td>
                            </tr>
                            <tr>
                                <th>제목</th>
                                <td>
                                    <input type="text" placeholder="제목을 입력해주세요." required
                                           value={qna.title} onChange={(e) => {
                                        changeDTO(setQna, 'title', e.target.value)
                                    }}>
                                    </input>
                                </td>
                            </tr>
                            <tr>
                                <th>내용</th>
                                <td>
                                    <textarea placeholder="내용을 입력해주세요." required minLength='10'
                                              value={qna.content} onChange={(e) => {
                                        changeDTO(setQna, 'content', e.target.value)
                                    }}>
                                        </textarea>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <span>※ 정확한 정보를 입력하셔야 빠른 답변을 받으실수 있습니다.
                    </span>

                    <div>
                        <button className="btnPositive btnQuestion"
                                style={{fontFamily: '함초롱바탕', width: '100px', height: '30px'}}
                                onClick={async () => {
                                    if (qna.title !== '' && qna.content !== '' && qna.email !== '' && qna.cate !== '' && qna.type !== '')
                                        axios.post(`${API_BASE_URL}/cs/qna/writing`, qna)
                                            .then((res) => {
                                                alert('문의가 등록되었습니다.')
                                                setPopup('')
                                            })
                                            .catch((err) => {
                                                console.log(err)
                                            })
                                    else
                                        alert('정보를 정확히 입력해주세요')
                                    await setPopup('qna')
                                }}
                        >문의하기
                        </button>
                    </div>

                </section>
            </div>
        </div>
    </>
}

export default QnaPopup