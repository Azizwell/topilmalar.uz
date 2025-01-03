import { useNavigate } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";

import { setHasUser, setUser } from "../store/slices/appSlices";
import Navbar from "../components/Navbar";
import Carousel from "../components/Carousel";
import Country from "../components/Country";
import Apply from "../components/Apply";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faArrowRightFromBracket } from "@fortawesome/free-solid-svg-icons";
import StatisticsPage from "../components/StatisticsPage";
import { useRef } from "react";
// import "bootstrap/dist/css/bootstrap.min.css";
export default function Root() {
  const { user, hasUser } = useSelector((state) => state.app);
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const statisticsRef = useRef(null);
  const logOutHandler = () => {
    localStorage.removeItem("user");

    dispatch(setUser(null));
    dispatch(setHasUser(false));
  };

  function apply(params) {
    if (localStorage.getItem("user")) {
      dispatch(setHasUser(true));
      console.log("true");
    } else {
      navigate("/login");
    }
  }

  const scrollToStatistics = (e) => {
    e.preventDefault();
    if (statisticsRef.current) {
      statisticsRef.current.scrollIntoView({ behavior: "smooth" });
    }
  };

  return (
    <>
      <div className="   navbar-sys d-lg-flex d-grid items-center">
        <div className=" p-10 flex justify-between items-center w-100">
          <a className="logo-system text-decoration-none " href="/">
            <img
              src="data:image/png;base64,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"
              alt="topilmalar-logo"
            />
          </a>
          <div className="list-page d-none d-lg-flex align-items-center">
            <a href="/reestr">Reyestr</a>
            <a onClick={scrollToStatistics} href="/">
              Statistika
            </a>
            <a href="/">Tizim haqida</a>
            <a href="/">Repo</a>
          </div>
          <div className=" flex gap-1 items-center  ">
            <button
              onClick={() => apply()}
              className="bg-blue-500 rounded-md p-2 h-12 hover:bg-white hover:text-blue-500 hover:border-blue-600 border transition text-white btn-auth "
            >
              Ariza berish
            </button>
            {localStorage.getItem("user") ? (
              <div className="flex items-center gap-1">
                <img
                  src={`http://localhost:8080/api/file/${user.image}`}
                  alt=""
                  className="rounded-circle border-2 border-blue-800 b rounded-full me-2"
                  style={{ width: "60px", height: "60px" }}
                />
                <h1>{user.email}</h1>

                <div
                  onClick={() => logOutHandler()}
                  className="text-blue-600 cursor-pointer "
                >
                  <FontAwesomeIcon icon={faArrowRightFromBracket} />
                  Chiqish
                </div>
              </div>
            ) : (
              <button
                onClick={() => navigate("/login")}
                type="button cursor-pointer"
                className="bg-blue-500 rounded-md p-2 h-12 hover:bg-white hover:text-blue-500 hover:border-blue-600 border transition text-white btn-auth "
              >
                Kirish
              </button>
            )}
          </div>
        </div>
      </div>
      {!hasUser ? (
        <div>
          <Navbar />
          <Carousel />
          <Country />
          <div ref={statisticsRef}>
            <StatisticsPage />
          </div>
        </div>
      ) : (
        <Apply />
      )}
    </>
  );
}
