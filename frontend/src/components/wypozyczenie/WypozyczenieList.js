import React, {useEffect, useState} from "react";
import axios from "../../axios/axios";
import {Grid} from "@mui/material";
import classes from "./WypozyczenieList.module.css"
import {Button} from "react-bootstrap";
import moment from "moment";


const WypozyczenieList = () => {
    const [listWypozyczenie, setterWypozyczenieList] = useState([]);

    useEffect(()=>{
        axios.get("/api/wypozyczenie/list")
            .then((response)=>{
                console.log(response);
                setterWypozyczenieList(response.data)
            })
            .catch((error)=>{
                console.log(error);
            });
    },[]);

    return(
        <div>

            <Grid container  className={classes.TableHeader}>
                <Grid item xs={1}>Id</Grid>
                <Grid item xs={1}>Data wypożyczenia</Grid>
                <Grid item xs={1}>Data zwrotu</Grid>
                <Grid item xs={1}>Cena za dobę</Grid>
                <Grid item xs={1}>Do zapłaty</Grid>
                <Grid item xs={1}>Nr kompletu</Grid>
                <Grid item xs={1}>Telefon Klienta</Grid>
                <Grid item xs={1}>Nazwisko Klienta</Grid>
            </Grid>
            {
                listWypozyczenie.map(value => {
                    //Formatuję datę wypozyczenia
                    var dataWypo=value.dataWypozyczenia
                    var dataWypoGrid=moment(dataWypo).format('DD/MM/YY HH:MM')
                    //Formatuję datę zwrotu
                    var dataZwro=value.dataZwrotu
                    var dataZwroGrid=moment(dataZwro).format('DD/MM/YY HH:MM')


                    return (<Grid container className={classes.TableRow}>
                        <Grid item xs={1}>{value.idWypozyczenie}</Grid>
                        <Grid item xs={1}>{dataWypoGrid}</Grid>
                        <Grid item xs={1}>{dataZwroGrid}</Grid>
                        <Grid item xs={1}>{value.cenaWypozyczenia}</Grid>
                        <Grid item xs={1}>{value.cenaOstateczna}</Grid>
                        <Grid item xs={1}>{value.idKomplet}</Grid>
                        <Grid item xs={1}>{value.nrTelefonu}</Grid>
                        <Grid item xs={1}>{value.nazwisko}</Grid>
                    </Grid>)
                })
            }
            <div>
                <Button  onClick={window.print}>drukuj</Button>
            </div>

        </div>
    );
}
export default WypozyczenieList;