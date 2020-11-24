import React, { useEffect, useState } from "react";
import ProTypes from "prop-types";

import Image from "../../components/Image";
import Comment from "../../components/Comment";
import styles from "./index.module.css";
import { FormattedMessage } from "react-intl";

import cx from "classnames";

import config from "../../config";
import request from "axios";
import capitalizeString from "../../helpers/capitalizeString";

const Sandwhich = props => {
  const [loading, setLoading] = useState(true);
  const [sandwich, setSandwich] = useState({});
  const [errorMessage, setErrorMessage] = useState(null);

  useEffect(() => {
    async function getSandwich() {
      const sandwichId = props.match.params.id;
      const {
        api: { basePath },
      } = config;

      try {
        const returnedSandwich = (
          await request(`${basePath}/sandwich/${sandwichId}`)
        ).data;
        setSandwich(returnedSandwich);
        setLoading(false);
      } catch (e) {
        const errorStatus = e.response && e.response && e.response.status;

        if (errorStatus === 404) {
          setErrorMessage("error.noSandwich");
        } else {
          setErrorMessage("error.tryAgain");
        }
        setLoading(false);
      }
    }

    getSandwich();
  }, [props.match.params.id]);

  const renderComments = () => {
    if (sandwich.comments.length === 0) {
      return (
        <div className={cx("container", styles.noCommentsContainer)}>
          <FormattedMessage id="sandwich.noComments" />
        </div>
      );
    }

    return sandwich.comments.map((c, index) => {
      let rating = null;
      if (c.rating) {
        rating = {
          value: c.rating,
          minimum: c.minimumRating,
          maximum: c.maximumRating,
        };
      }
      return (
        <div key={index} className={cx("container", styles.commentContainer)}>
          <Comment
            author={c.user.name}
            title={c.title}
            content={c.content}
            rating={rating}
          />
        </div>
      );
    });
  };

  return (
    <div className="container">
      {loading && (
        <span className={styles.loadingContainer}>
          <FormattedMessage id="loading" />
          ...
        </span>
      )}
      {errorMessage && (
        <div className={styles.errorMessageContainer}>
          <FormattedMessage id={errorMessage} />
        </div>
      )}
      {!loading && !errorMessage && (
        <div>
          <div className={cx("row", styles.imageContainer)}>
            <div className="col">
              <Image />
            </div>
            <div className="col align-self-center">
              <div>{sandwich.name}</div>
              <div>
                <FormattedMessage id="sandwich.type" />:{" "}
                {capitalizeString(sandwich.type)}
              </div>
              <div>
                <FormattedMessage id="sandwich.description" />:{" "}
                {capitalizeString(sandwich.description)}
              </div>
            </div>
          </div>
          <div className="row">
            {sandwich && sandwich.comments && renderComments()}
          </div>
        </div>
      )}
    </div>
  );
};

Sandwhich.propTypes = {
  match: ProTypes.object.isRequired,
};

export default Sandwhich;
