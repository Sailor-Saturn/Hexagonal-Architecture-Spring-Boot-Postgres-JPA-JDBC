import React from "react";
import { FormattedMessage } from "react-intl";

import styles from "./index.module.css";

const Home = () => {
  return (
    <div className={styles.welcomeText}>
      <FormattedMessage id="home.welcome" />
    </div>
  );
};

export default Home;
