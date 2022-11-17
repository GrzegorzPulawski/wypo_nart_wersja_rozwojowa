import {useEffect, useState} from "react";
import axios from "../../axios/axios";
import classes from "./ButyList.module.css";
import {Grid} from "@mui/material";
import {Link} from "react-router-dom";
import {Button} from "react-bootstrap";


function ButyList() {
    //Deklaracja zmiennej
    const [butyListuj, setterButyListuj] = useState([]);

    useEffect(() =>{
        axios.get("/api/buty")
            .then((response)=>{
                console.log(response);
                setterButyListuj(response.data)
            })
            .catch((error)=>{
                console.log(error);
            });
    },[]);

    return(
        <div>
            <Grid container className={classes.ButyTableHeader}>
                <Grid item xs={1}>Id</Grid>
                <Grid item xs={3}>Nazwa butów</Grid>
                <Grid item xs={1}>Rozmiar</Grid>
                <Grid item xs={3}>NARTY/SNOWBOARD</Grid>
            </Grid>
            <div className={classes.Button}>
                <Link to={"/form"}>
                    <Button variant="light" type={"submit"}>Dodaj do listy</Button>
                </Link>
            </div>
            {
                butyListuj.map(value => {
                    return (
                        <Grid container className={classes.ButyTableRow}>
                        <Grid item xs={1}>{value.idButy}</Grid>
                        <Grid item xs={3}>{value.nazwaButow}</Grid>
                        <Grid item xs={1}>{value.rozmiarButow}</Grid>
                        <Grid item xs={3}>{value.rodzajButow}</Grid>
                        </Grid>)
                })
            }

        </div>
    );
}
export default ButyList;
