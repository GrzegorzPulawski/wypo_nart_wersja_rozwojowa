import classes from "./KompletList.module.css";
import React, {useEffect, useState} from "react";
import {Grid} from "@mui/material";
import axios from "../../axios/axios";



const KompletList = () => {
    //Deklaracja nowej zmiennej
    const [nazwaZmiennej, setterDoKolekcji] = useState([]);

    useEffect(() => {
        axios.get("/api/komplet")
            .then((response) => {
                console.log(response);
                setterDoKolekcji(response.data)
            })
            .catch((error) => {
                console.log(error);
            });
    }, []);

    return(
        <div>
        <Grid container className={classes.TableHeader}>
                <Grid item xs={1}>Id</Grid>
                <Grid item xs={3}>Nazwa kompletu</Grid>
                <Grid item xs={2}>Cena doba w zł</Grid>
            </Grid>

            {
                nazwaZmiennej.map(value => {
                    return (<Grid container className={classes.TableRow}>
                        <Grid item xs={1}>{value.idKomplet}</Grid>
                        <Grid item xs={3}>{value.nazwaKomplet}</Grid>
                        <Grid item xs={2}>{value.cenaDoba}</Grid>
                    </Grid>)
                })
            }
        </div>
    );
}
export default KompletList;