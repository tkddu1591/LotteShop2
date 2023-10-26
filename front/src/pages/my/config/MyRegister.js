import React, {useEffect, useState} from "react";
import {useForm} from "react-hook-form";
import MyUserRegister from "./MyUserRegister";
import MyRequiredInformation from "./MyRequiredInformation";
import axios from "axios";
import {useNavigate} from "react-router-dom";
import {useSelector} from "react-redux";
import MyPassChange from "./MyPassChange";

function MyRegister({userRegisterType, member, setDivName}) {
    let ip = useSelector((state) => state.ip);
    let [passChange, setPassChange] = useState(false);
    const {
        watch,
        register,
        setValue,
        formState: {
            errors,
        }, handleSubmit
    } = useForm({mode: "onBlur"});
    const onValid = async (data) => {
        await axios.post(`${process.env.REACT_APP_API_ROOT}/member/change`, data)
            .then(res => {
                alert('수정되었습니다.')
            }).catch(err => {

            });
    }
    let [postOn, setPostOn] = useState(false);
    let [postDTO, setPostDTO] = useState({
        zip: member.zip,
        addr1: member.addr1,
        addr2: member.addr2,
    });
    useEffect(() => {
        setValue("zip", postDTO.zip)
        setValue("addr1", postDTO.addr1)
        setValue("addr2", postDTO.addr2)
    }, [postDTO]);
    if (userRegisterType === "") {
        return <div className="register">
            <nav><h1>정보를 불러오는 중 오류가 발생했습니다. 처음부터 다시 시도해주세요.</h1></nav>
        </div>
    } else {
        return <>
            <div className="register">
                <nav>
                    {userRegisterType === "USER" && <h1>일반 회원정보</h1>}
                    {userRegisterType === "SELLER" && <h1>판매자 회원정보</h1>}
                </nav>
                {passChange?
                    <MyPassChange setPassChange={setPassChange} member={member} register={register} errors={errors}
                                  watch={watch} handleSubmit={handleSubmit} setDivName={setDivName}></MyPassChange>:

                <form onSubmit={handleSubmit(onValid)}>
                    <input type="hidden" {...register('regIp')} value={ip}/>
                    <input type="hidden" {...register('uid')} value={member.uid}/>
                    <MyRequiredInformation setPassChange={setPassChange} member={member} register={register} errors={errors}
                                           watch={watch}></MyRequiredInformation>

                    {userRegisterType === "USER" &&
                        <MyUserRegister member={member} register={register} errors={errors} setPostOn={setPostOn}
                                        postDTO={postDTO}
                                        postOn={postOn} setPostDTO={setPostDTO} watch={watch}></MyUserRegister>}


                    <div>
                        <input type="submit" className="join" value="수정하기"/>
                    </div>
                </form>}
            </div>
        </>
    }
}

export default MyRegister;