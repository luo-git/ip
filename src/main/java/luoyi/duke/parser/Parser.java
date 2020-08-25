package luoyi.duke.parser;

import luoyi.duke.commands.*;
import luoyi.duke.common.Message;
import luoyi.duke.data.exception.DukeIllegalArgumentException;
import luoyi.duke.data.exception.DukeUnrecognizedArgumentException;

/**
 * Parser class to handle command string parsing.
 */
public class Parser {
    /**
     * Parse a command and returns the corresponding command object.
     * @see Command For details of command objects.
     *
     * @param commandStr Command string.
     * @return Command object to execute.
     * @throws DukeIllegalArgumentException If the command string is invalid.
     */
    public static Command parse(String commandStr) throws DukeIllegalArgumentException {
        if (commandStr.matches("^list.*")) {
            // Found list command
            if (commandStr.equals("list")) {
                return ListCommand.getListCommand(null);
            } else if (!commandStr.matches("^list .+")) {
                throw new DukeIllegalArgumentException(
                        Message.ERR_WRONG_LIST_CMD.toString());
            }
            return ListCommand.getListCommand(commandStr.split(" ", 2)[1]);
        } else if (commandStr.matches("^done.*")) {
            // Found done command
            if (!commandStr.matches("^done -?[0-9]+$")) {
                throw new DukeIllegalArgumentException(
                        Message.ERR_WRONG_DONE_CMD.toString());
            }
            int index = Integer.parseInt(commandStr.split(" ", 2)[1]);
            return DoneCommand.getDoneCommand(index);
        } else if (commandStr.matches("^todo.*")) {
            // Found todo command
            if (!commandStr.matches("^todo .*")) {
                throw new DukeIllegalArgumentException(
                        Message.ERR_WRONG_TODO_CMD.toString());
            }
            String description = commandStr.split(" ", 2)[1];
            return ToDoCommand.getToDoCommand(description);
        } else if (commandStr.matches("^deadline.*")) {
            // Found deadline command
            if (!commandStr.matches("^deadline .* /by .*")) {
                throw new DukeIllegalArgumentException(
                        Message.ERR_WRONG_DEADLINE_CMD.toString());
            }
            String[] params = commandStr.split(" ", 2)[1].split(" /by ");
            return DeadlineCommand.getDeadlineCommand(params[0], params[1]);
        } else if (commandStr.matches("^event.*")) {
            // Handle event command
            if (!commandStr.matches("^event .* /at .*")) {
                throw new DukeIllegalArgumentException(
                        Message.ERR_WRONG_EVENT_CMD.toString());
            }
            String[] params = commandStr.split(" ", 2)[1].split(" /at ");
            return EventCommand.getEventCommand(params[0], params[1]);
        } else if (commandStr.matches("^delete.*")) {
            // Handle delete command
            if (!commandStr.matches("^delete -?[0-9]+$")) {
                throw new DukeIllegalArgumentException(
                        Message.ERR_WRONG_DELETE_CMD.toString());
            }
            int index = Integer.parseInt(commandStr.split(" ")[1]);
            return DeleteCommand.getDeleteCommand(index);
        } else if (commandStr.matches("^find.*")) {
            // Handle find command
            if (!commandStr.matches("^find .*")) {
                throw new DukeIllegalArgumentException(
                        Message.ERR_WRONG_DELETE_CMD.toString());
            }
            String searchString = commandStr.split(" ", 2)[1];
            return FindCommand.getFindCommand(searchString);
        }
        throw new DukeUnrecognizedArgumentException(Message.ERR_WRONG_CMD.toString());
    }
}
