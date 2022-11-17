import classes from "./NartyList.module.css";
import React, {useEffect, useState} from "react";
import {Grid} from "@mui/material";
import axios from "../../axios/axios";
import {Link} from "react-router-dom";
import {Button} from "react-bootstrap";


const NartyList = () => {
    //Deklaracja nowej zmiennej
    const [nazwaZmiennej, setterDoKolekcji] = useState([]);

    useEffect(() => {
        axios.get("/api/narty")
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
            <Grid container  className={classes.NartyTableHeader}>
                <Grid item xs={1}>Id</Grid>
                <Grid item xs={2}>Długość nart</Grid>
                <Grid item xs={2}>Nazwa</Grid>
                <Grid item xs={3}>NARTY/SNOWBOARD</Grid>
            </Grid>
            <div className={classes.Button}>
                <Link to={"/formNarty"}>
                    <Button variant="light" type="submit">Dodaj do listy</Button>
                </Link>
            </div>
            {
                nazwaZmiennej.map(value => {
                    return (<Grid container className={classes.NartyTableRow}>
                        <Grid item xs={1}>{value.idNart}</Grid>
                        <Grid item xs={2}>{value.dlugoscNart}</Grid>
                        <Grid item xs={2}>{value.nazwaNart}</Grid>
                        <Grid item xs={3}>{value.rodzajNart}</Grid>
                    </Grid>)
                })
            }

        </div>

    );
}
export default NartyList;