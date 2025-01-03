import {
  faClipboard,
  faClipboardList,
  faCopy,
  faTable,
  faTextSlash,
} from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import React, { useEffect } from "react";
import Carousel from "react-multi-carousel";
import "react-multi-carousel/lib/styles.css";
import { useGetCarouselInfoQuery } from "../store/services/globalServices";
import { useDispatch, useSelector } from "react-redux";
import { setCarouselData } from "../store/slices/appSlices";
import { toast } from "react-toastify";

const CustomCarousel = () => {
  const { data, isSuccess } = useGetCarouselInfoQuery();
  const { carouselData } = useSelector((state) => state.app);
  const dispatch = useDispatch();
  // Настройки карусели
  const responsive = {
    superLargeDesktop: {
      // Большие экраны
      breakpoint: { max: 4000, min: 1024 },
      items: 3, // Показывать 5 слайдов
    },
    desktop: {
      breakpoint: { max: 1024, min: 768 },
      items: 3, // Показывать 3 слайда
    },
    tablet: {
      breakpoint: { max: 768, min: 464 },
      items: 2, // Показывать 2 слайда
    },
    mobile: {
      breakpoint: { max: 464, min: 0 },
      items: 1, // Показывать 1 слайд
    },
  };

  useEffect(() => {
    if (isSuccess) {
      dispatch(setCarouselData(data));
    }
  }, [isSuccess]);

  return (
    <div className="m-14">
      <h1 className="text-center text-6xl m-4">E’lonlar</h1>
      <Carousel
        responsive={responsive}
        infinite={true}
        autoPlay={true}
        autoPlaySpeed={2000}
        centerMode={true}
      >
        {carouselData?.map((item) => (
          <div
            onClick={() => {
              navigator.clipboard
                .writeText(item.serialNumber)
                .then(() => {
                  toast.info("Reestrdagi seriya raqami nusxa olindi!"); // Уведомление пользователю
                })
                .catch((err) => {
                  console.error("Ошибка при копировании: ", err);
                });
            }}
            key={item.createdDate}
            className="mt-20 me-4 carousel-data p-2 border rounded-md border-blue-600 w-full group  hover:border-green-600 hover:translate-y-[-44px] transition"
          >
            <div className="data-name w-full flex justify-between items-center">
              <div className="type-data flex items-center">
                <div className="circle w-2.5 h-2.5 rounded-full bg-blue-500 group-hover:bg-green-500 "></div>
                <span className="mx-1 text-lg text-blue-600 group-hover:text-green-600">
                  {item.entityType}
                </span>
              </div>
              <div className="ico-data text-blue-600 group-hover:text-green-600">
                <FontAwesomeIcon icon={faClipboard} />
                <i className="fa-regular fa-clipboard"></i>
              </div>
            </div>
            <div className="data-reestr">
              <div className="number_reestr">
                <span id="key" className="text-sm ">
                  Reyestrdagi seriya va raqami:
                </span>
                <div className="bg-blue-500 rounded-md p-2 data-number px-1 flex justify-between items-center group-hover:bg-green-500">
                  <div className="text-sm text-white">{item.serialNumber}</div>
                  <div className="flex items-center">
                    <FontAwesomeIcon icon={faCopy} color="white" />
                  </div>
                </div>
              </div>
              <div className="data-type mt-2 flex items-center">
                <span id="key" className="text-sm">
                  Topilmaning turi:
                </span>
                <div id="value" className="ml-2">
                  {item.entityName}
                </div>
              </div>
              <div className="data-name my-2 flex items-center">
                <span id="key" className="text-sm truncate ">
                  Topilmaning nomi:
                </span>
                <div id="value" className="ml-2 truncate">
                  {item.name}
                </div>
              </div>
              <div className="data-center flex items-center">
                <span id="key" className="text-sm truncate  ">
                  Yo'qolgan tuman:
                </span>
                <div id="value" className="ml-2">
                  {item.regionName}
                </div>
              </div>
            </div>
          </div>
        ))}
      </Carousel>
    </div>
  );
};

export default CustomCarousel;
