import React from "react";
import classes from "./Home.module.css";
import {Card} from "react-bootstrap";

function Home() {
    return(
    <Card className={classes.Glowne}>
        <Card.Img src={"https://picsum.photos/id/1036/1200/800"}/>
    <Card.Body>
        <Card.Title>
            Program do wypożyczalni nart i snowboardów
    </Card.Title>
        <Card.Text>
            Instrukcja dla użytkownika programu...
        </Card.Text>
    </Card.Body>
    </Card>
    )
}
export default Home;