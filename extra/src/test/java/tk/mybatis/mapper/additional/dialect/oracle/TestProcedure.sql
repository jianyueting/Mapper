create or replace PROCEDURE CUBE_SUM (PARAM1 in number default 1, PARAM2 in number default 10, RES in out number) as
  begin
    declare n number;
    begin
      RES:=0;
      n := PARAM1;
      while n <= PARAM2 loop
        begin
          RES := RES + n;
          n := n + 1;
        end;
      end loop;
    end;
  end CUBE_SUM;