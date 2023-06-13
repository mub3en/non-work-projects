# Form Design Project with Editing Function

This project is implemented using React and React Bootstrap. It focuses on designing a form with an editing function. The form includes two tables: Writing Table and Speaking Table.

## Components and Dependencies

- `React`: JavaScript library for building user interfaces.
- `react-bootstrap`: React UI framework for styling.
- `TableStructure`: Component for rendering table structures.
- `FilterComponent`: Component for filtering data based on transfer credits.
- `writing_data`: Data for the Writing Table.
- `speaking_data`: Data for the Speaking Table.
- `Banner`: Component for displaying a banner.
- `BannerInput`: Component for inputting the user's name.
- `TransferCreditInput`: Component for inputting transfer credits.
- `App.css`: CSS file for styling.

## Functionality

- The form allows the user to input their name and transfer credits.
- The `handleSetUserName` function updates the `username` state with the entered name and disables the banner input field.
- The `handleSetCredits` function updates the `transferCredits` state with the entered transfer credits.
- The `FilterComponent` function filters the writing and speaking data based on the transfer credits entered.
- The `BannerInput` component renders an input field for entering the user's name.
- The `TransferCreditInput` component renders an input field for entering transfer credits.
- The `TableStructure` component renders the tables with the filtered data and provides a save function (`handleSave`) for each table.

## Rendering

The `App` component renders the following elements:

- BannerInput (for entering the user's name)
- TransferCreditInput (for entering transfer credits)
- Writing Table (with the filtered writing data and save function)
- Speaking Table (with the filtered speaking data and save function)

Please note that this Markdown code provides an overview of the code's functionality and structure. For the actual implementation and execution, you would need to refer to the original JavaScript code and run it in a React development environment.


Happy editing!
