import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  user: JSON.parse(localStorage.getItem("user")),
  hasUser: false,
  region: [],
  district: [],
  givenRegion: [],
  LossDistrict: [],
  market: [],
  item: [],
  viewReestr: [],
  viewReestrItem: [],
  reestrData: [],
  carouselData: [],
  regionStat: [],
  statistic: [],
  search: {
    type: "",
    status: "",
    miniType: "",
    region: "",
    district: "",
    serialNumber: "",
  },
  applicantId: "",
  hasStatis: false,
  isSearch: false,
};

export const appSlices = createSlice({
  name: "app",
  initialState,
  reducers: {
    setUser: (state, actions) => {
      state.user = actions.payload;
    },
    setDistrict: (state, actions) => {
      state.district = actions.payload;
    },
    setRegion: (state, actions) => {
      state.region = actions.payload;
    },
    setLossDistrict: (state, actions) => {
      state.LossDistrict = actions.payload;
    },
    setGivenRegion: (state, actions) => {
      state.givenRegion = actions.payload;
    },
    setHasUser: (state, actions) => {
      state.hasUser = actions.payload;
    },
    setMarket: (state, actions) => {
      state.market = actions.payload;
    },
    setItem: (state, actions) => {
      state.item = actions.payload;
    },
    setApplicant: (state, actions) => {
      state.applicantId = actions.payload;
    },
    setViewReestr: (state, actions) => {
      state.viewReestr = actions.payload;
    },
    setViewReestrItem: (state, actions) => {
      state.viewReestrItem = actions.payload;
    },
    setSearch: (state, actions) => {
      state.search = actions.payload;
    },
    setReestrData: (state, actions) => {
      state.reestrData = actions.payload;
    },
    setHasStatis: (state, actions) => {
      state.hasStatis = actions.payload;
    },
    setCarouselData: (state, actions) => {
      state.carouselData = actions.payload;
    },
    setIsSearch: (state, actions) => {
      state.isSearch = actions.payload;
    },
    setStatistic: (state, actions) => {
      state.statistic = actions.payload;
    },
    setRegionStat: (state, actions) => {
      const regionStat = actions.payload;

      const totalcount = regionStat.reduce(
        (sum, reg) => sum + reg.entityCount,
        0
      );
      const totalInactiveEntityCount = regionStat.reduce(
        (sum, reg) => sum + reg.inactiveEntityCount,
        0
      );
      const totalRegion = {
        regionName: "jami",
        entityCount: totalcount,
        inactiveEntityCount: totalInactiveEntityCount,
      };

      const updateRegionState = [...regionStat, totalRegion];
      state.regionStat = updateRegionState;
    },
  },
});

export const {
  setViewReestr,
  setUser,
  setRegion,
  setHasUser,
  setDistrict,
  setLossDistrict,
  setGivenRegion,
  setMarket,
  setApplicant,
  setItem,
  setViewReestrItem,
  setSearch,
  setReestrData,
  setCarouselData,
  setIsSearch,
  setRegionStat,
  setStatistic,
} = appSlices.actions;

export default appSlices.reducer;
