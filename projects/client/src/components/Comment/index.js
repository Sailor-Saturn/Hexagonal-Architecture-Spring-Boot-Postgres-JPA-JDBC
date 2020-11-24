import React from "react";
import styles from "./index.module.css";
import cx from "classnames";
import { FormattedMessage } from "react-intl";
import PropTypes from "prop-types";

const Comment = props => {
  const renderRating = () => {
    const {
      rating: { value, minimum, maximum },
    } = props;
    return (
      <span>
        <FormattedMessage
          id="comment.rating"
          values={{ value, minimum, maximum }}
        />
      </span>
    );
  };

  return (
    <div className={styles.container}>
      <div className={cx("col", styles.author)}>
        <div>
          <strong>{props.title}</strong> <FormattedMessage id="comment.by" />{" "}
          {props.author}
        </div>
        <div>{props.rating && renderRating()}</div>
      </div>
      <div className={cx("col", styles.comment)}>{props.content}</div>
    </div>
  );
};

Comment.propTypes = {
  author: PropTypes.string.isRequired,
  content: PropTypes.string.isRequired,
  title: PropTypes.string.isRequired,
  rating: PropTypes.shape({
    value: PropTypes.number.isRequired,
    minimum: PropTypes.number.isRequired,
    maximum: PropTypes.number.isRequired,
  }),
};

export default Comment;
