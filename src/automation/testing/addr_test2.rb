require "json-schema"
class String
def black;          "\e[30m#{self}\e[0m" end
def red;            "\e[31m#{self}\e[0m" end
def gray;           "\e[37m#{self}\e[0m" end


def bg_brown;       "\e[43m#{self}\e[0m" end
def bg_gray;        "\e[47m#{self}\e[0m" end
def bg_red;        "\e[41m#{self}\e[0m" end

def bold;           "\e[1m#{self}\e[22m" end
def blink;          "\e[5m#{self}\e[25m" end
def reverse_color;  "\e[7m#{self}\e[27m" end
end
# address should have "addrLine1", "city", "state","postalCode"
schema = {
  "type"=>"object",
  "required" => ["addrLine1", "city", "state","postalCode"],
  "properties" => {
    "addrLine1" => {
      "type" => "string"
    },
    "city" => {
      "type" => "string"
    },
    "state" => {
      "type" => "string"
    },
    "postalCode" => {
      "type" => "string"
    }
  },
  "additionalProperties" => {
    "addrLine2" => {
      "type" => "string"
    },
    "country" => {
      "type" => "string"
     }
    }
  }
json = {
  "addrLine1":"4531 pisano terr",
  "addrLine2":"",
  "postalCode":"94568",
  "country":""
}
puts "Press enter to view next example: "
gets.to_s
puts ("Basic address json validation 2.: address json missing mandatory fields:" + "city, state".red).bold.bg_gray
puts json.to_s.bold.bg_brown
puts "Press enter to validate:".bold.red
gets.to_s
errors = JSON::Validator.fully_validate(schema, json)
if(errors.size > 0)
  puts "given json has these errors: #{errors}".red
else
  puts "Great! json looks good ".gray
end

load "addr_test3.rb"


# => false
#flag = JSON::Validator.validate(schema, [{ "a" => 1, "b" => { "x" => 2 }, "c" => 3 }], [:list,:strict] => true)
#puts("flag is : #{flag}")
# => false
#flag = JSON::Validator.validate(schema, [{ "a" => 1 }], [:list,:strict] => true)
#puts("flag is : #{flag}")