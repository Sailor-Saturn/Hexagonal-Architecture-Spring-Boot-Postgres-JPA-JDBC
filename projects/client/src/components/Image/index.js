import React from "react";
import styles from "./index.module.css";
import img from "./image.jpg";

const Image = () => {
  return <img src={img} className={styles.image}></img>;
};

export default Image;
