import {useState} from "react";

function Register() {
    let [member, setMember] = useState({

    })
    return <>
        <div className="register">
            <nav>
                <h1>판매자 회원가입</h1>
            </nav>

            <div>
                <section>
                    <table>
                        <caption>필수 정보입력</caption>
                        <tbody>
                            <tr>
                                <th><span className="essential">*</span>아이디</th>
                                <td><input type="text" name="km_uid" placeholder="아이디를 입력"
                                           required/> <span className="msgSId">&nbsp;&nbsp;영문, 숫자로
										4~12자까지 설정해 주세요.</span></td>
                            </tr>
                            <tr>
                                <th><span className="essential">*</span>비밀번호</th>
                                <td><input type="password" name="km_pass"
                                           placeholder="비밀번호를 입력" required/> <span className="msgPass">&nbsp;&nbsp;영문,
										숫자, 특수문자를 조합하여 8~12자까지 설정해 주세요.</span></td>
                            </tr>
                            <tr>
                                <th><span className="essential">*</span>비밀번호확인</th>
                                <td><input type="password" name="km_pass"
                                           placeholder="비밀번호를 확인" required/> <span className="msgPass">&nbsp;&nbsp;비밀번호
										재입력</span></td>
                            </tr>
                        </tbody>
                    </table>
                </section>

                <section>
                    <table>
                        <caption>판매자 정보입력</caption>
                        <tbody>
                            <tr>
                                <th><span className="essential">*</span>회사명</th>
                                <td><input type="text" name="kms_company"
                                           placeholder="회사명 입력" required/> <span
                                    className="msgCompany">&nbsp;&nbsp;(주)포함
										입력, 예) (주)케이마켓</span></td>
                            </tr>
                            <tr>
                                <th><span className="essential">*</span>대표자</th>
                                <td><input type="text" name="kms_ceo" placeholder="대표자 입력"
                                           required/></td>
                            </tr>
                            <tr>
                                <th><span className="essential">*</span>사업자등록번호</th>
                                <td><input type="text" name="kms_corp_reg"
                                           placeholder="사업자등록번호 입력" required/> <span className="msgCorp">&nbsp;&nbsp;-
										표시 포함 12자리 입력, 예) 123-45-67890</span></td>

                            </tr>
                            <tr>
                                <th><span className="essential">*</span>통신판매업신고 번호</th>
                                <td><input type="text" name="kms_online_reg"
                                           placeholder="통신판매업신고 입력" required/> <span className="msgOnline">&nbsp;&nbsp;-
										표시 포함, 예) 강남-12345, 제 1-01-23-4567호, 2017-경기성남-0011</span></td>
                            </tr>
                            <tr>
                                <th><span className="essential">*</span>전화번호</th>
                                <td><input type="text" name="kms_tel" placeholder="전화번호 입력"
                                           required/> <span className="msgTel">&nbsp;&nbsp;- 표시 포함,
										지역번호 포함, 예) 02-234-1234</span></td>
                            </tr>
                            <tr>
                                <th><span className="essential">*</span>팩스번호</th>
                                <td><input type="text" name="kms_fax" placeholder="팩스번호 입력"
                                           required/> <span className="msgFax">&nbsp;&nbsp;- 표시 포함,
										지역번호 포함, 예) 02-234-1234</span></td>
                            </tr>
                            <tr>
                                <th><span className="essential">*</span>EMAIL</th>
                                <td><input type="email" name="kms_email"
                                           placeholder="이메일 입력" required/></td>
                            </tr>
                            <tr className="addr">
                                <th>회사주소</th>
                                <td>
                                    <div>
                                        <input type="text" name="kms_zip" id="zip"
                                               placeholder="우편번호 입력 클릭" readonly/>
                                    </div>
                                    <div>
                                        <input type="text" name="kms_addr1" id="addr1" size="50"
                                               placeholder="주소를 검색하세요." readonly/>
                                    </div>
                                    <div>
                                        <input type="text" name="kms_addr2" id="addr2" size="50"
                                               placeholder="상세주소를 입력하세요."/>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </section>
                <section>
                    <table>
                        <caption>담당자 정보입력</caption>
                        <tbody>
                            <tr>
                                <th><span className="essential">*</span>이름</th>
                                <td><input type="text" name="km_name" placeholder="이름을 입력"
                                           required/></td>
                            </tr>
                            <tr>
                                <th><span className="essential">*</span>휴대폰</th>
                                <td><input type="text" name="km_hp" maxlength="13"
                                           placeholder="휴대폰번호 입력" required/> <span className="msgHp">&nbsp;&nbsp;-
										포함 13자리를 입력하세요.</span></td>
                            </tr>
                        </tbody>
                    </table>
                </section>

                <div>
                    <input type="submit" className="join" value="회원가입"/>
                </div>
            </div>
        </div>
    </>
}

export default Register;