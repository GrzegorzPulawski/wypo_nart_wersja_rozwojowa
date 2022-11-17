import React from "react";
import classes from "./AppHeader.module.css";
import {Link} from "react-router-dom";
import { Container} from "react-bootstrap";
const AppHeader = () => {
    return (
        <div className={classes.AppHeader}>

            <div className={classes.HeaderLeft}>
                <img src={"https://picsum.photos/id/146/100/50"}/>
                    <div>Mały Wypożycza Narty</div>
            </div>

            <Container className={classes.HeaderRight}>
                <Link to={"/"}>
                    <div>Home</div>
                </Link>
                <Link to={"/formKlient"}>
                    <div>Formularz klienta</div>
                </Link>
                <Link to={"/rent"}>
                    <div>Wypożycz</div>
                </Link>
                <Link to={"/list"}>
                    <div>Narty Listuj</div>
                </Link>
                <Link to={"/butyList"}>
                    <div>Buty Listuj</div>
                </Link>
                <Link to={"/zestaw-form"}>
                    <div>Formularz zestawu</div>
                </Link>
            </Container>
        </div>
    );

}
export default AppHeader;