import DaumPost from "../../../store/DaumPost";
import React from "react";
import MyEmailCheck from "./MyEmailCheck";

function MyUserRegister({postOn, register, postDTO, setPostDTO, setPostOn, errors, watch, member}) {

    function maskingName(name) {
        if (name.length <= 2) {
            return name.replace(name.substring(0, 1), "*");
        }

        return (
            name[0] +
            "*".repeat(name.substring(1, name.length - 1).length) +
            name[name.length - 1]
        );
    }
    return <>
        <section>
            <table>
                <caption>기본 정보</caption>
                <tbody>
                    <tr>
                        <th><span className="essential"></span>이름</th>
                        <td><input type="text" name="km_name" placeholder="이름 입력" value={maskingName(member.name)}
                        style={{backgroundColor:'lightgray'}}/>
                        </td>

                    </tr>
                    <tr>
                        <th><span className="essential"></span>성별</th>
                        <td>
                            {member.gender ===1? '남자':'여자'}
                        </td>
                    </tr>
                    <MyEmailCheck member={member} errors={errors} watch={watch} register={register}></MyEmailCheck>
                    <tr>
                        <th><span className="essential"></span>휴대폰</th>
                        <td><input type="text" name="km_hp" maxLength="13" defaultValue={member.hp}
                                   placeholder="휴대폰번호 입력" required
                                   {...register("hp", {
                                       required: "휴대폰번호를 입력해 주세요.",
                                       pattern: {
                                           value: /^01(?:0|1|[6-9])-(\d{4})-\d{4}$/,
                                           message: '유효한 휴대폰 번호를 입력해주세요'
                                       }
                                   })}
                                   style={errors.hp && {border: 'solid 2px red'}}
                        /><span>&nbsp;&nbsp;- 포함하여 13자리를 입력해주세요.</span>
                            {errors.hp && <div style={{color: 'red'}}>{errors.hp.message}</div>}</td>
                    </tr>
                    <tr className="addr">
                        <th>주소</th>
                        <td>
                            <div>
                                <input type="text" name="km_zip" id="zip" placeholder="우편번호 검색 클릭"
                                       readOnly {...register('zip')}
                                       value={postDTO.zip}
                                       onClick={() => {
                                           setPostOn(!postOn)
                                       }}/>
                            </div>
                            <div>
                                <input type="text" name="km_addr1" id="addr1" size="50" value={postDTO.addr1}
                                       placeholder="주소를 검색하세요." {...register('addr1')} readOnly/>
                            </div>
                            <div>
                                <input type="text" name="km_addr2" id="addr2" size="50"
                                       defaultValue={postDTO.addr2}
                                       {...register('addr2')}
                                       placeholder="상세주소를 입력하세요."/>
                            </div>
                            {postOn && <>
                                <DaumPost setPostDTO={setPostDTO} setPostOn={setPostOn}></DaumPost>
                            </>}
                        </td>
                    </tr>
                </tbody>
            </table>
        </section>
    </>
}

export default MyUserRegister