import React, { useEffect, useState } from "react";
import SandwichPanel from "../../components/SandwichPanel";
import Cart from "../../components/Cart";
import styles from "./index.module.css";
import request from "axios";
import { FormattedMessage } from "react-intl";

import config from "../../config";

const CART_ITEMS = [
  {
    quantity: 5,
    name: "Mushroom Sandwich",
  },
  {
    quantity: 5,
    name: "Cheese Sandwich",
  },
  {
    quantity: 5,
    name: "Stawberry Sandwich",
  },
];

const SandwichesList = () => {
  const [loading, setLoading] = useState(true);
  const [sandwiches, setSandwiches] = useState([]);
  const [errorMessage, setErrorMessage] = useState(null);

  const getSandwiches = async () => {
    const {
      api: { basePath },
    } = config;

    try {
      const returnedSandwiches = (await request.get(`${basePath}/sandwich`))
        .data;
      setSandwiches(returnedSandwiches);
      setLoading(false);
    } catch (e) {
      setErrorMessage("error.tryAgain");
      setLoading(false);
    }
  };

  useEffect(() => {
    getSandwiches();
  }, []);

  const renderSandwichesPanel = () => {
    return (
      <div className="row">
        {sandwiches.map((s, index) => (
          <div className="col-4" key={index}>
            <SandwichPanel
              className={styles.sandwichPanel}
              id={s.id}
              name={s.name}
            />
          </div>
        ))}
      </div>
    );
  };

  const renderCart = () => <Cart items={CART_ITEMS} />;

  return (
    <div className="container-fluid">
      <div className="row">
        {loading && (
          <span className={styles.loadingContainer}>
            <span className={styles.loadingContainer}>
              <FormattedMessage id="loading" />
              ...
            </span>
          </span>
        )}
        {errorMessage && (
          <div className={styles.errorMessageContainer}>
            <FormattedMessage id={errorMessage} />
          </div>
        )}
        {!loading && !errorMessage && (
          <div className="col-12">
            <div className="col-12">{renderSandwichesPanel()}</div>
            {null && <div className="col">{renderCart()}</div>}
          </div>
        )}
      </div>
    </div>
  );
};

export default SandwichesList;
