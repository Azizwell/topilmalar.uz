import React, { useEffect } from "react";
import { setLossDistrict, setMarket } from "../../store/slices/appSlices";
import { useDispatch, useSelector } from "react-redux";
import { useGetMarketsQuery } from "../../store/services/globalServices";
import { useState } from "react";

const Document = ({
  setSelectedGivenRegion,
  setSelectedLossDistrict,
  selectedGivenRegion,
  selectedLossDistrict,
  register,
  selectedMiniTypes,
  setSelectedMiniTypes,
}) => {
  const dispatch = useDispatch();
  const { givenRegion, LossDistrict, market } = useSelector(
    (state) => state.app
  );
  const { data, isSuccess, refetch } = useGetMarketsQuery();
  useEffect(() => {
    if (selectedGivenRegion != "") {
      givenRegion.forEach((item) => {
        if (item.id === selectedGivenRegion) {
          dispatch(setLossDistrict(item.district));
        }
      });
    }

    if (selectedGivenRegion == "") {
      dispatch(setLossDistrict([]));
    }
    setSelectedLossDistrict("");
  }, [selectedGivenRegion]);

  useEffect(() => {
    if (isSuccess) {
      dispatch(setMarket(data));
    }
  }, [isSuccess]);

  return (
    <div>
      <div className="flex gap-2 flex-col">
        <label className="stars " htmlFor="miniType ">
          Kichik turni tanlang
        </label>
        <select
          className="bg-transparent border outline-0 rounded-md p-2 border-blue-600"
          name="miniType"
          id="miniType"
          {...register("marketId", {
            required: "Kichik turni tanlang ",
          })}
          value={selectedMiniTypes}
          onChange={(e) => setSelectedMiniTypes(e.target.value)}
          autoComplete="region"
        >
          <option value="">Tanlang...</option>
          {market.map((item, index) => (
            <option key={index} value={item.id}>
              {item.name}
            </option>
          ))}
        </select>
      </div>

      <div className="flex gap-2 flex-col mt-2">
        <label className="stars ">
          Hujjat tegishli bo'lgan shaxsning F.I.SH
        </label>
        <input
          {...register("snp", {
            required: " Hujjat tegishli bo'lgan shaxsning F.I.O ",
          })}
          className="bg-transparent border outline-0 rounded-md p-2 border-blue-600"
          type="text"
          placeholder=""
        />
      </div>

      <div className="flex gap-2 flex-col mt-2">
        <label className="stars ">Nomi</label>
        <input
          {...register("name", {
            required: " nomi ",
          })}
          className="bg-transparent border outline-0 rounded-md p-2 border-blue-600"
          type="text"
          placeholder=""
        />
      </div>

      <div className="flex gap-2 flex-col mt-2">
        <label className="stars ">Hujjatning mazmuni</label>
        <input
          {...register("docContent", {
            required: " mazmuni ",
          })}
          className="bg-transparent border outline-0 rounded-md p-2 border-blue-600"
          type="text"
          placeholder=""
        />
      </div>
      <div className="flex gap-2 flex-col mt-2">
        <label className="stars ">Seriya va raqami</label>
        <input
          {...register("documentSerialNumber", {
            required: " Seriya va raqami ",
          })}
          className="bg-transparent border outline-0 rounded-md p-2 border-blue-600"
          type="text"
          placeholder=""
        />
      </div>
      <div className="flex gap-2 flex-col mt-2">
        <label className=" ">Ishlab chiqilgan yoki berilgan sanasi</label>
        <input
          {...register("givenDate")}
          className="bg-transparent border outline-0 rounded-md p-2 border-blue-600"
          type="date"
          placeholder="kun.oy.yil"
        />
      </div>
      <div className="flex gap-2 flex-col mt-2">
        <label className="stars ">Taxminiy yo'qotilgan sana</label>
        <input
          {...register("lossDate", {
            required: " Taxminiy yo'qotilgan sana ",
          })}
          className="bg-transparent border outline-0 rounded-md p-2 border-blue-600"
          type="date"
        />
      </div>

      <div className="flex gap-2 flex-col mt-2">
        <label className="stars " htmlFor="region ">
          Taxminiy yo'qotilgan hudud
        </label>
        <select
          className="bg-transparent border outline-0 rounded-md p-2 border-blue-600"
          name="region"
          id="region"
          {...register("givenRegionId", {
            required: "taxminiy yuqotilgan hududni tanlang ",
          })}
          value={selectedGivenRegion}
          onChange={(e) => setSelectedGivenRegion(e.target.value)}
          autoComplete="region"
        >
          <option value="">Tanlang...</option>
          {givenRegion.map((item, index) => (
            <option key={index} value={item.id}>
              {item.name}
            </option>
          ))}
        </select>
      </div>
      <div className="flex gap-2 flex-col mt-2">
        <label className="stars " htmlFor="region ">
          Taxminiy yo'qotilgan tuman
        </label>
        <select
          className="bg-transparent border outline-0 rounded-md p-2 border-blue-600"
          name="district"
          id="district"
          {...register("lossDistrictId", {
            required: " taxminiy yuqotilgan tumanni tanlang ",
          })}
          value={selectedLossDistrict}
          onChange={(e) => setSelectedLossDistrict(e.target.value)}
        >
          <option value="">Tanlang...</option>
          {LossDistrict.map((item, index) => (
            <option key={index} value={item.id}>
              {item.name}
            </option>
          ))}
        </select>
      </div>

      <div className="flex gap-2 flex-col mt-2">
        <label className="stars ">Taxminiy yo'qotilgan manzil</label>
        <input
          {...register("lossAddress", {
            required: " Taxminiy yo'qotilgan manzil ",
          })}
          className="bg-transparent border outline-0 rounded-md p-2 border-blue-600"
          type="text"
        />
      </div>
    </div>
  );
};

export default Document;
