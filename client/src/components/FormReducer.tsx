export const INITIAL_STATE = {
  email: "",
  password: "",
  username: "",
  displayName: "",
  dateOfBirth: "",
};

export const FormReducer = (state: any, action: any) => {
  switch (action.type) {
    case "CHANGE_INPUT":
      return { ...state, [action.payload.name]: action.payload.value };
    default:
      return state;
  }
};
