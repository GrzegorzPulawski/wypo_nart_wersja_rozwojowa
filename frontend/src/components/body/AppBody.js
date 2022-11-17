import React from "react";
import classes from "./AppBody.module.css";
import { Route, Routes} from "react-router-dom";
import Home from "../home/Home";
import NartyList from "../equipmentlist/NartyList";
import Form from "../form/Form";
import ButyList from "../equipmentlist/ButyList";
import FormNarty from "../form/FormNarty";
import EquipmentForm from "../equipment/EquipmentForm";
import KompletList from "../equipmentlist/KompletList";
import KlientList from "../formKlient/KlientList";
import KlientForm from "../formKlient/KlientForm";
import Wypozyczenie from "../wypozyczenie/Wypozyczenie";
import WypozyczenieList from "../wypozyczenie/WypozyczenieList";
import Zwrot from "../wypozyczenie/Zwrot";


const AppBody = () => {

        return(
            <div className={classes.AppBody}>
                <Routes>
                    <Route path={"/"} element={<Home/>}></Route>
                    <Route path={"/form"} element={<Form/>}></Route>
                    <Route path={"/rent"} element={<Wypozyczenie/>}></Route>
                    <Route path={"/kompletList"} element={<KompletList/>}></Route>
                    <Route path={"/list"} element={<NartyList/>}> </Route>
                    <Route path={"/butyList"} element={<ButyList/>}></Route>
                    <Route path={"/formNarty"} element={<FormNarty/>}></Route>
                    <Route path={"/zestaw-form"} element={<EquipmentForm/>}></Route>
                    <Route path={"/klient-list"} element={<KlientList/>}></Route>
                    <Route path={"/formKlient"} element={<KlientForm/>}></Route>
                    <Route path={"/wypozyczenielist"} element={<WypozyczenieList/>}></Route>
                    <Route path={"/zwrot-wypozyczenia"} element={<Zwrot/>}></Route>
                </Routes>
                </div>

        );

}

export default AppBody;